monitor:
	javac MonitorSemaphore.java
tester: monitor
	javac RaceThreadsMonitorSemaphore.java

all: monitor tester

test: monitor tester
	    java RaceThreadsMonitorSemaphore 10000
tar: 
	tar czvf P16.tar.gz MonitorSemaphore.java RaceThreadsMonitorSemaphore.java readme.txt makefile
