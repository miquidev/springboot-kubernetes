**# Implementación de Spring Boot en Kubernetes

Esta guía te ayudará a desplegar una aplicación Spring Boot en Kubernetes usando Minikube.

## Prerrequisitos

- Asegúrate de tener Docker, Minikube y kubectl instalados en tu máquina.

## Pasos

1. **Iniciar Minikube**

    Minikube es una herramienta que te permite ejecutar Kubernetes localmente. Inícialo con el siguiente comando:

    ```bash
    minikube start
    ```

2. **Configurar el entorno Docker**

    Apunta tu terminal para usar el demonio Docker dentro de la instancia de Minikube:

    ```bash
    eval $(minikube docker-env)
    ```

3. **Construir la imagen Docker**

    Navega al directorio del proyecto y construye la imagen Docker:

    ```bash
    cd /ruta/a/tu/proyecto
    docker build -t springboot-kubernetes:v1 .
    ```

    Puedes verificar las imágenes Docker con:

    ```bash
    docker images
    ```

4. **Desplegar la aplicación**

    Aplica la configuración de despliegue de Kubernetes:

    ```bash
    kubectl apply -f deployment.yaml
    ```

    Puedes verificar el estado de los despliegues con:

    ```bash
    kubectl get deployments
    ```

    Y el estado de los pods con:

    ```bash
    kubectl get pods
    ```

    Para ver los registros de un pod específico:

    ```bash
    kubectl logs <nombre-del-pod>
    ```

5. **Exponer la aplicación**

    Aplica la configuración del servicio de Kubernetes para exponer la aplicación:

    ```bash
    kubectl apply -f service.yaml
    ```

    Puedes verificar el estado del servicio con:

    ```bash
    kubectl get service
    ```

    Y el estado de todos los servicios con:

    ```bash
    kubectl get svc
    ```

6. **Verificar los nodos**

    Para obtener más detalles sobre los nodos en el clúster:

    ```bash
    kubectl get nodes -o wide
    ```

## Prueba la aplicación

Para probar la aplicación, usa el siguiente formato de URL:
http://{IpDelNodo}:{PUERTO}/{URL DE LA API}
Reemplaza `{IpDelNodo}` con la IP de tu nodo, `{PUERTO}` con el número de puerto y `{URL DE LA API}` con el endpoint específico de la API que deseas acceder.**