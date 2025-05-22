#!/bin/bash

# ESTE ARQUIVO FAZ PARTE DO PROJETO MOTTUFLOW 
# DISCIPLINA: DEVOPS TOOLS & CLOUD COMPUTING - Feli
# ALUNOS:
# - João Gabriel Boaventura Marques e Silva RM554874 | 2TDSB-2025
# - Leo Motta Lima RM557851 | 2TDSB-2025
# - Lucas Leal das Chagas RM551124 | 2TDSB-2025 

echo "--------------------------------"
echo "INSTALANDO DOCKER, AGUARDE..."
echo "--------------------------------"
echo ""

set -e

sudo apt-get update
sudo apt-get install -y ca-certificates curl gnupg

sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "${UBUNTU_CODENAME:-$VERSION_CODENAME}") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

sudo apt-get update
sudo apt-get install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

sudo usermod -aG docker $USER

sudo reboot
