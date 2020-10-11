# Pubchem compounds indexing and search
Test project, where I am studying spring cloud with features like load balancing, using some chemical library, index chemical related data in elastic search and deploying it into kubernetes

## To build project use (in root dir of project):
`gradle wrapper --gradle-version 6.6.1` and `gradle build`

## k8s deploy 
### For minikube. Maybe you want to point your shell to minikube's docker daemon,- use this before:
Windows: `& minikube -p minikube docker-env | Invoke-Expression`

Linux: `eval $(minikube docker-env)`

**Or** use the last command from output of `docker ps` command
### Steps to deploy on kubernetes:
cd client

docker build -t pubchem-app-client .

kubectl delete -f client-service-deployment.yaml

kubectl create -f client-service-deployment.yaml

cd ..