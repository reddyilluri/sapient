pipeline 
{
    environment
    {
    
    scannerHome = tool 'sonar_scanner'
    }
  agent any
  stages 
  {
               
     stage('Sonarqube'){
      steps{
        echo "Sonarqube codequality"
          sh ''' 
            sonar-scanner \
                -Dsonar.projectKey=Cmd-angular \
                -Dsonar.sources=. \
                -Dsonar.host.url=http://52.45.81.194:9000 \
                -Dsonar.login=sqp_a8c60440b7b3a9fc92b83aaba14ec24b493d2216
          '''

                         }     
              }



  }

}
