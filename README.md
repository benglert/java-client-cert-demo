### Test Instructions

Bring up both servers:
`docker-compose up -d`


### Test via Web App

Access via web application:
http://localhost:8081/tls



### Test via Linux Bash

Connect to client:
`docker exec -it client "bash"`

Access HTTP endpoint on server:
`wget http://test.local/`

Access HTTPS endpoint without client cert:
`wget --no-check-certificate https://test.local/`

Access HTTPS endpoint with client cert:
`curl -k --key /etc/certs/client.key --cert /etc/certs/client.crt https://test.local`


