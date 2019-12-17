docker build -t jeffersonfarias/trajeto-consumer:latest  -f Dockerfile .
docker login --username=jeffersonfarias
docker push jeffersonfarias/trajeto-consumer:latest
