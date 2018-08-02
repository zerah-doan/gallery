node {
   stage('Preparation') { 
      git 'https://github.com/zerah-doan/gallery.git'    
   }
   stage('Test') {
     bat 'mvn clean test'
   }
   stage('Results') {
     cucumber fileIncludePattern: '**/*.json', sortingMethod: 'ALPHABETICAL'
   }
}
