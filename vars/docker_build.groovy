def call(Srting ImageName, String ImageTag, String DockerHubUser){
  sh "docker build -t ${DockerHubUser}/${ImageName}:${ImageTag} ."
}
