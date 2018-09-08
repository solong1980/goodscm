package springboot.mybatis;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.Resource;

/**
 * mybatis的mapper文件有改动时，手动重新加载
 */
public class MyBatisSqlSessionWatcher extends MyBatisSqlSessionManager {
	public MyBatisSqlSessionWatcher(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	public void refreshMapper() throws Exception {
		// Create Watcher
		super.scanMapperXml();

		Resource[] mapperLocations = getMapperLocations();

		WatchService mapperWatchService = FileSystems.getDefault().newWatchService();
		Kind<?>[] events = { StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY };

		Map<Path, WatchKey> pathWatchKeyPathMap = new HashMap<>();

		Set<Path> dirs = new HashSet<>();
		for (Resource resource : mapperLocations) {
			URI uri = resource.getURI();
			//log.debug("mapping file resource1: " + uri.toString());
			//log.debug("mapping file resource2: " + new UrlResource(uri).toString());
			if("jar".equals(uri.getScheme())){
				//if file in jar ,can not be changed,so skip 
				/**
			    for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
			        if (provider.getScheme().equalsIgnoreCase("jar")) {
			            try {
			                provider.getFileSystem(uri);
			            } catch (FileSystemNotFoundException e) {
			                // in this case we need to initialize it first:
			                provider.newFileSystem(uri, Collections.emptyMap());
			            }
			        }
			    }
			    */
				continue;
			}
			//Path path = FileSystems.getDefault().getPath(new UrlResource(resource.getURI()).toString());
			Path path = Paths.get(uri);
			boolean directory = Files.isDirectory(path);
			if (!directory) {
				Path parent = path.getParent();
				dirs.add(parent);
			}
		}
		for (Path path : dirs) {
			WatchKey watchKey = path.register(mapperWatchService, events);
			pathWatchKeyPathMap.put(path, watchKey);
		}
		try {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						while (true) {
							WatchKey watchKey = mapperWatchService.take();
							if (watchKey != null) {
								Path watchablePath = (Path) watchKey.watchable();
								List<WatchEvent<?>> pollEvents = watchKey.pollEvents();
								if (!pollEvents.isEmpty()) {
									// do refresh
									boolean mapperChanged = false;
									for (WatchEvent<?> event : pollEvents) {
										Path path = watchablePath.resolve((Path) event.context());
										dirDelCheck(event, path);
										if (path.toString().endsWith(".xml")) {
											mapperChanged = true;
										}
									}
									if (mapperChanged)
										// update
										cleanLoad();
								}
								watchKey.reset();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				protected void dirDelCheck(WatchEvent<?> event, Path path) {
					if (event.kind().equals(StandardWatchEventKinds.ENTRY_DELETE)) {
						if (Files.isDirectory(path) && !Files.exists(path)) {
							WatchKey oWatchKey = pathWatchKeyPathMap.get(path);
							if (oWatchKey != null) {
								pathWatchKeyPathMap.remove(path);
								oWatchKey.cancel();
							}
						}
					}
				}
			};

			ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
			service.schedule(runnable, 1, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					for (Entry<Path, WatchKey> entry : pathWatchKeyPathMap.entrySet()) {
						entry.getValue().cancel();
					}
				}
			}));
		}
	}

	public static void main(String[] args) {
		HashMap<String, Long> fileMapping = new HashMap<String, Long>();
		boolean f = !fileMapping.isEmpty() && !fileMapping.containsKey("Hello.xml");
		System.out.println(f);
	}
}