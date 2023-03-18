# portfolio_service

Run this service in local and it will connect to local mongodb docker.
First run mongodb docker and the start spring boot appplication.


steps to run mongo db docker.(you need docker desktop for it)
run below command from command prompt
docker pull mongo:latest
docker run -d -p 27017:27017 --name portfoliodb mongo:latest 
docker ps  -- to check whether its running or not
