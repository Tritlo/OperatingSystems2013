1. Start server using (adjust classpath parameter -cp to let it point to the directory that contains the ch3process sub directories that contain the *.class files)
java -cp /home/helmut/workspace/OperatingSystems/bin/ ch3Processes.connectionOrientedSocket.ConnectionOrientedServer

2. Start on same machine client using (adjust classpath)
java -cp /home/helmut/workspace/OperatingSystems/bin/ ch3Processes.connectionOrientedSocket.ConnectionOrientedClient Hello localhost