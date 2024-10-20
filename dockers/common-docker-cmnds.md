# DOCKER =======================================================

1. docker version
2. docker run -d -p 8800:80 httpd ---: Running apache server-1 container with an assigned unique IP
3. curl 127.0.0.1:8800
4. docker run -d -p 8801:80 httpd ---: Running apache server-2 container with an assigned unique IP














===================================================================================================================
1. docker ps ---: For all the docker containers running
2. docker stop <container_id>
3. docker login ---: login to docker
4. docker pull store/oracle/database-enterprise:12.2.0.1 ---: docker pull request
5. docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql  ---: MySQL run command
6. docker pull mysql
7. docker stop some-mysql ---: Stop the container <some-mysql>
8. docker run --rm mysql
9. docker container ls ---: check the running containers
10. docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <container_name_or_id>  ---: to check IP of container
11. docker start <container_name> /docker start -ai <container_name>  ---: Restart the container

12. sudo apt-get update 
-> sudo apt-get install docker.io 
-> sudo systemctl start docker 
-> sudo systemctl enable docker
-> docker --version 
-> docker pull quay.io/maksymbilenko/oracle-12c 
-> docker run -d -p 1521:1521 -e ORACLE_PWD=root --name oracle-xe quay.io/maksymbilenko/oracle-12c
-> docker logs -f oracle-xe ---: For monitoring the oracle installation logs
-> docker exec -it oracle-xe /bin/bash
-> yum install -y oracle-instantclient19.3-sqlplus
-> sqlplus -v
-> sqlplus sys/oracle@localhost:1521/XE as sysdba

---: Docker installation and starting in LINUX

13. docker start oracle-12c/ docker stop oracle-xe ---: start/stop docker image -> oracle-12c
14. docker --version ---: Version chk

======== Make use of Docker compose file ===================

1. docker-compose up
2. docker-compose down
3. docker ps
4. docker stop <container_id>
5. docker rm <container_id>

==============================================================