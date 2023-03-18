# portfolio_service

Run this service in local and it will connect to local mongodb docker.
First run mongodb docker and the start spring boot appplication.


steps to run mongo db docker.(you need docker desktop for it)

1) run below command from command prompt
2) docker pull mongo:latest
3) docker run -d -p 27017:27017 --name portfoliodb mongo:latest
4) docker ps  -- to check whether its running or not
