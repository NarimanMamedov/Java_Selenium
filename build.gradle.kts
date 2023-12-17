plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    //implementation ("log4j:log4j: 1.2.17")
    implementation("log4j:log4j:1.2.17")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")
    implementation("org.seleniumhq.selenium:selenium-java:4.15.0")

    //implementation group: 'log4j', name: 'log4j', version: '1.2.17'
    //implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.15.0'
    //testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: '5.10.1'
    //testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.10.1'

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    //implementation("org.seleniumhq.selenium:selenium-java:2.41.0")
    //testImplementation("org.testng:testng:7.8.0")
}

tasks.test {
    //    useTestNG();
    useJUnitPlatform()
}