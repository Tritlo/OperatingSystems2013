monitor:
	javac MonitorSemaphore.java
tester: monitor
	javac RaceThreadsMonitorSemaphore.java

all: monitor tester

test: monitor tester
	    java RaceThreadsMonitorSemaphore 10000
