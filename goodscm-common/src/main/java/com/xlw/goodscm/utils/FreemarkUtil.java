package com.xlw.goodscm.utils;

import java.io.File;
import java.io.IOException;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkUtil {
	public Configuration buildConfiguration() throws IOException {
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding("utf-8");
		TemplateLoader ctl = new ClassTemplateLoader(FreemarkUtil.class, "/ftl");
		TemplateLoader ftl1 = new FileTemplateLoader(new File(System.getProperty("user.dir")));
		MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[] { ftl1, ctl });
		configuration.setTemplateLoader(mtl);
		return configuration;
	}

	public Template getTemplate(String ftlName) throws IOException {
		Configuration configuration = buildConfiguration();
		return configuration.getTemplate(ftlName);
	}
}
