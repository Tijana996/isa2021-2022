# isa2021-2022

# Uputstvo za pokretanje projekta

-Backend
  - U PgAdminu (localhost) napraviti bazu tijana2
  - U Intellij-u otvoriti folder ISA2122. U fajlu application.properties: spring.datasource.username i spring.datasource.password postaviti na lokalni username i password, i spring.jpa.hibernate.ddl-auto postaviti na 'create'; i nakon toga pokrenuti aplikaciju
  - Kada je aplikacija uspesno pokrenuta, prekunti izvrsavanje, i spring.jpa.hibernate.ddl-auto podesiti na update, u fajlu data-postgres.sql otkomentarisati sve inserte i ponovo pokrenuti aplikaciju
  -  Ukoliko se prekine izvrsavanje i aplikacija treba da se pokrene opet - zakomentarisati sve inserte u fajlu data-postgres.sql

-Frontend:
  - U Visual Studio Codu, uz pomoc naredbe 'cd' u terminalu, locirati se u folder ISA2122Front i pokrenuti izvrsavanje koda uz pomoc naredbe 'ng serve'

-Na pretrazivacu otvoriti http://localhost:4200/

-Kredencijali:
  - Admin - email: markomarkovic@gmail.com, password: admin
  - Klijent - email:anaanic@gmail.com, password: admin


target/
!.mvn/wrapper/maven-wrapper.jar

### STS ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache/

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr

### NetBeans ###
nbproject/private/
build/
nbbuild/
dist/
nbdist/
.nb-gradle/# See http://help.github.com/ignore-files/ for more about ignoring files.

# See http://help.github.com/ignore-files/ for more about ignoring files.

node/
bin/

# compiled output
/dist
/tmp
/out-tsc
# Only exists if Bazel was run
/bazel-out

# dependencies
/node_modules

# profiling files
chrome-profiler-events*.json

# IDEs and editors
/.idea
.project
.classpath
.c9/
*.launch
.settings/
*.sublime-workspace

# IDE - VSCode
.vscode/*
!.vscode/settings.json
!.vscode/tasks.json
!.vscode/launch.json
!.vscode/extensions.json
.history/*

# misc
/.angular/cache
/.sass-cache
/connect.lock
/coverage
/libpeerconnection.log
npm-debug.log
yarn-error.log
testem.log
/typings

# System Files
.DS_Store
Thumbs.db
