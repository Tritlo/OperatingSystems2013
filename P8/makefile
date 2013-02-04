all:
	javac Connection.java
	javac ConnectionOrientedServer.java
	javac ConnectionOrientedClient.java

test:
	java ConnectionOrientedServer &
	java ConnectionOrientedClient Hello localhost
