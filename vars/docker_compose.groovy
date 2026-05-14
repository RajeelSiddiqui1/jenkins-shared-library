def call (){
  echo 'Deploy has been started'
  sh "docker-compose down && docker compose up -d "
  echo 'deploy successfully'
}
