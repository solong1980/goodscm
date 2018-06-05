ps -ef | grep java | grep goodscm-service | awk '{print "kill -9 ",$2}' | sh

nohup java -jar goodscm-service.jar  1>log.txt 2>&1 &