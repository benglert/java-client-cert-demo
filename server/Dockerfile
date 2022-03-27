FROM ubuntu:16.04

RUN apt-get update

#Tools
RUN apt-get install -y nano wget dialog net-tools

# Install Nginx
RUN apt-get install -y nginx

# Remove the default Nginx configuration file and add cert directory
RUN rm -v /etc/nginx/nginx.conf


# Add ngnix config file
ADD nginx.conf /etc/nginx/


# Add certifcate (crt and key)
#ADD certs/ca.crt /etc/nginx/certs/
#ADD certs/client.crt /etc/nginx/certs/
#ADD certs/server.crt /etc/nginx/certs/
#ADD certs/server.key /etc/nginx/certs/

ADD scripts/createServerCert.sh /tmp/

RUN sh /tmp/createServerCert.sh

RUN echo "password" >> /etc/nginx/key_pwd

RUN echo "daemon off;" >> /etc/nginx/nginx.conf
RUN chown -R www-data:www-data /var/lib/nginx

VOLUME ["/etc/nginx/sites-enabled", "/etc/nginx/certs", "/etc/nginx/conf.d", "/var/log/nginx", "/var/www/html"]

# Expose ports 80 to redirect
EXPOSE 80 443

CMD ["nginx"]