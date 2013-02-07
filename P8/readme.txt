Made by:
Matthías Páll Gissurarson, mpg3@hi.is and
Haukur Óskar Þorgeirsson, hth152@hi.is

Part 1 can be found in ./code, Part 2 and 3 here.

netstat output can be found in netstatoutput.txt and services can be found in services.txt.

part 2:

'Local Address' is a name of the local machine and the port-number the process is using. You often see localhost, or, when using Matthías' computer, milleniumfalcon.

Foreign Address is, as the name indicates, the IP address and port number of the remote machine. From around line 30 in netstatoutput.txt you can see that the foreign machine is also called localhost. (At least part of) these are the threaded Connection Oriented Client and Server that are running.

part 3:

The first column is the name of a service and the second column is a port number said service would use by default, should it ask for a port number, as well as the protocol (TCP or UDP). Column 3 appears to be aliases for the services. The fourth column is populated by comments.
