def call(String Project, String ImageTage, String dockerHubUser){
 withCredentials([usernamePassword(credentialsId: "DockerHubCred", 
                                 usernameVariable: 'dockerHubUser', 
                                 passwordVariable: 'dockerHubPass')]){
                sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
                sh "docker image tag notes-app:latest ${dockerHubUser}/django-note-app:latest"
                sh "docker push ${dockerHubUser}/${Project}:${ImageTage}"
}
