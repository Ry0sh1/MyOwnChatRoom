# MyOwnChatRoom
A Project i did to learn Java Sockets, IO and their connected it with my knowledge on Databases. 

To download the newest Version of the Client go to /client/out/artifcats/Client.jar
You need to download both jars and store it in the same Folder otherwise it wont work.

I worked on this project exact one week intensively to apply my knew knowledge on Sockets, IOStreams, Databanks etc.

Short overview over the functions:
You can chat with other people in a group chat and you can chat with other people in private.
I am using two Server although I could have done it in one but that would have been more work.
The first Server is only receiving SQL Commands from the client to get the userdatas from my 
User Databank. The only Thing stored in my User Databank is username, password and ip address.
My Second Server is handling incoming messages and redirect them to every user.
The method I used to send the messages to the right person isnt done in my Server. My Server is
only receiving and redirecting. That means that every message that is send to my Server will be 
send to every person connected to my Server. But the Client will sort out every message that is not 
for him, so you wont get every message. Because of this the most work is in the Client. 

Group Chat messages will not be saved in any Databank but private Messages will be stored in your 
own databank that is created when you first open the program.

I am sharing upcoming changes in the Client so dont forget to update it ;)
