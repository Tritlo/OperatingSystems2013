all: server client

client:
	javac Connection.java
	javac ConnectionOrientedClient.java

handler:
	javac requestHandlerThread.java

server: handler
	javac ConnectionOrientedServer.java

testserver:
	java ConnectionOrientedServer

testclient:
	java ConnectionOrientedClient Test1 localhost&
	java ConnectionOrientedClient Test2	localhost&
	java ConnectionOrientedClient Test3 localhost&
	java ConnectionOrientedClient Test4 localhost&
	java ConnectionOrientedClient Test5 localhost&
	java ConnectionOrientedClient Test6 localhost&
	java ConnectionOrientedClient Test7 localhost&
	java ConnectionOrientedClient Test8 localhost&
	java ConnectionOrientedClient Test9 localhost&

clean:
	rm *.class
