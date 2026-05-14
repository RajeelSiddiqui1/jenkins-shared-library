def call(String Project, String ImageTag, String HubUser){
    withCredentials([usernamePassword(credentialsId: "DockerHubCred", 
                                     usernameVariable: 'D_USER', 
                                     passwordVariable: 'D_PASS')]){
        
        // Login
        sh "echo ${D_PASS} | docker login -u ${D_USER} --password-stdin"
        
        // Image tag (Aapki built image 'HubUser/Project' format mein hai)
        // Hum purani image ko naye 'Project' naam ke sath tag kar rahe hain agar zaroorat ho
        sh "docker image tag ${HubUser}/notes-app:${ImageTag} ${D_USER}/${Project}:${ImageTag}"
        
        // Push to Docker Hub
        sh "docker push ${D_USER}/${Project}:${ImageTag}"
    }
}
