# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#image de base Payara micro version 4.181
FROM payara/micro:4.181
# copie du war dans le dossier où Payra Micro recherche les war à lancer
COPY target/CoffeeCustomer-1.0-SNAPSHOT.war /opt/payara/deployments
