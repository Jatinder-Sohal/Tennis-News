!/bin/bash

(cd backend && mvn spring-boot:run) &

(cd frontend && npm start)