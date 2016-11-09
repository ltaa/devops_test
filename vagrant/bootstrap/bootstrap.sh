#!/usr/bin/env bash

apt-get update
sudo apt-get install -y apt-transport-https ca-certificates
sudo apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80 --recv-keys 58118E89F3A912897C070ADBF76221572C52609D
echo "deb https://apt.dockerproject.org/repo ubuntu-trusty main" | sudo tee /etc/apt/sources.list.d/docker.list
sudo apt-get update
sudo apt-get install -y docker-engine linux-image-extra-$(uname -r) linux-image-extra-virtual
#sudo usermod -aG docker vagrant
#sudo service docker start

#apt-get -y install python-pip

#sudo reboot
