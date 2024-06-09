# Bank-System-Using-RMI

## Description

This project implements a client-server architecture for providing banking services, with a centralized system design. The system comprises client devices, two master servers, and multiple worker servers connected in a hierarchical structure. Clients interact with the system through client devices, which communicate with master servers acting as intermediaries. Each master server is responsible for specific worker servers corresponding to different geographic regions. Remote method invocation (RMI) is used for all connections and communication within the system.

## System Components

The system is composed of client devices (e.g. 4 clients) and 2 Master Servers, each connected to 3 Worker Servers. 

## System Design

As shown in the figure, the clients are connected to a Master Server which then connects to the worker servers to provide services for the clients. The architecture shown is a client-server model where the master servers act like intermediate servers between the clients and the worker servers. The clients are the end-users that request services from the servers, the master server is an intermediate server that receives the client requests and forwards them to the worker servers, and lastly, the worker servers provide the services requested by the clients. Therefore, the architecture is centralized. 

## System Description

Each master server is responsible for specific worker servers of different regions. Depending on the area of the clients, they will be connected to the appropriate master server which will then connect to the needed worker server. All connections and communication are done through remote method invocation (RMI). The clients’ location is determined before sending the request, and according to their geographic location, their request will either be sent to Master server 1 or Master server 2. The appropriate master server will then store the information of the connected client and forward their request to the suitable worker server according to the client’s location. The worker server will also save a copy of the client’s information and provide the service to the client where it is checking the balance, withdrawing, or depositing money. Updates between the worker servers and master servers are done automatically as part of the service implementation. The system doesn’t use the master servers to provide any kind of service, all services (aka. Checking balance, withdrawing, or depositing) are implemented and provided by the worker servers. The master servers only connect the two ends. The system also allows for back up between the master servers, so Master server 1 can store a backup of its information in the Master server 2 and vice versa. However, the backup is done manually by a press of a button.

## Advantages and Disadvantages of the system

Scalability –

•	Advantages: there are two master servers responsible for receiving client messages and forwarding them to worker servers. The choice of having two intermediate servers ameliorates the scalability of the system allowing more clients to use the system because it distributes the load on two intermediate servers rather than one. 

•	Disadvantages: there is a bottleneck for each intermediate server where the system can’t handle more requests than can be accepted by the master servers. If there were many clients in the system, which is usually the case, the server might go down due to the abundance of requested that it can’t handle (caused by the centralized architecture).

Fault Tolerance –

•	Advantages: given that the worker servers are distributed on two master servers, some of them will be accessible even if one master server goes down. The system will still be able to provide some services. In addition, given the assumption that all worker servers of the failed master server will be connected to a working master server increases the availability of all the services in the system and provides better fault tolerance but would still limit scalability since one master server can not handle the load previously shared by two.

•	Disadvantages: the availability of the services provided by the worker servers are largely dependent on the availability of the master servers, if one falls all worker servers will be inaccessible even if they are up and running. If the assumption that all worker servers of the failed master server will be connected to a working master server still holds, there is still a possibility that both master servers go down which will cause the entire system to fail since the worker servers will be inaccessible. The current system is highly dependent on the availability of the master servers which greatly limits its fault tolerance. 

Replication –

•	Advantages: the backup done between both master servers allows for better availability of the system assuming worker servers (of the failed master server) will connect to the master server that is up and running. Without the replication of data, this assumption wouldn’t have been valid. This allows for a more reliable and available system.

•	Disadvantages: replicating the information of the two servers is costly since replication takes a lot of memory space and ensuring that both replicas are consistent is an exhaustive procedure. Both of these points might affect the performance of the master servers since they now have more work to do (to ensure consistency) and less space to store new clients’ information. 

Consistency –

•	Advantages: the clients’ information is updated directly with any changes that could happen when withdrawing or depositing to their accounts. When the worker servers change in the clients’ balances, the system automatically updates the clients’ information in the master server database (arraylist to be more specific).

•	Disadvantages: the replicas in the different master servers need to be manually backed up, so it is very possible that the replicas will not be consistent the entire time. This will cause major problems if one master server goes down or fails and the replica in the other master server is not updated.

Load Balancing –

•	Advantages: there are two master servers sharing the load of forwarding client requests to the worker servers which provides a good sharing of request load. 

•	Disadvantages: master servers are the only entities responsible for connecting the clients and worker servers. That means that all nodes in the system must interact with the master servers to allow proper communication and the receiving of services which is not a good example for sharing the load in a system as a whole. 

