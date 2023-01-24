# Management of network equipment and services
We want to create a distributed application to manage equipment and services present in an IP network.
To do this, on the SNMP model, each machine to be managed will operate an agent with information
(on the service or the machine) that can be consulted and modified through a simple protocol - to be defined -
from a management application (the manager). In addition, during an event (of the information "update" type),
the agents will have to send an alert (trap) to the managers concerned.
In a more complete version, managers can be hierarchized in order to allow multi-user and more efficient management of equipment and services.
