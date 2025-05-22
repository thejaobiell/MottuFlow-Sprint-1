#!/bin/bash

# ESTE ARQUIVO FAZ PARTE DO PROJETO MOTTUFLOW 
# DISCIPLINA: DEVOPS TOOLS & CLOUD COMPUTING - Feli
# ALUNOS:
# - João Gabriel Boaventura Marques e Silva RM554874 | 2TDSB-2025
# - Leo Motta Lima RM557851 | 2TDSB-2025
# - Lucas Leal das Chagas RM551124 | 2TDSB-2025 



set -euo pipefail

TASK="Sprint1"

UBUNTU="Canonical:ubuntu-24_04-lts:server:24.04.202502210"
VM_SIZE="Standard_B2s"
LOCATION="brazilsouth"
USERNAME="azureuser"
PASSWORD="MottuFlow-2025"

RG_NAME="rg-mottuflow"
VNET_NAME="vnet-mottuflow"
SUBNET_NAME="snet-mottuflow"
NSG_NAME="nsg-mottuflow"
VM_NAME="vm-mottuflow"

echo "Iniciando a criação da Máquina Virtual, POR FAVOR AGUARDE..."

az group create -g $RG_NAME -l $LOCATION --tags Projeto=mottuflow Tarefa=$TASK

az network vnet create -n $VNET_NAME -g $RG_NAME --tags Projeto=mottuflow Tarefa=$TASK

az network vnet subnet create -n $SUBNET_NAME -g $RG_NAME \
  --vnet-name $VNET_NAME --address-prefixes 10.0.0.0/24

az network nsg create -n $NSG_NAME -g $RG_NAME --tags Projeto=mottuflow Tarefa=$TASK

az network nsg rule create \
  -n ssh \
  --nsg-name $NSG_NAME \
  --priority 1000 \
  --direction Inbound \
  --access Allow \
  --destination-address-prefixes VirtualNetwork \
  --destination-port-ranges 22 \
  --protocol Tcp \
  -g $RG_NAME

az vm create \
  -n $VM_NAME \
  -g $RG_NAME \
  --image $UBUNTU \
  --size $VM_SIZE \
  --vnet-name $VNET_NAME \
  --subnet $SUBNET_NAME \
  --nsg $NSG_NAME \
  --authentication-type password \
  --admin-username $USERNAME \
  --admin-password $PASSWORD \
  --tags Projeto=mottuflow Tarefa=$TASK

az vm open-port --port 8080 --resource-group $RG_NAME --name $VM_NAME --priority 1001

PUBLIC_IP=$(az vm show -d -g $RG_NAME -n $VM_NAME --query publicIps -o tsv)

echo ""
echo "VM criada com sucesso!"
echo "Aguardando a VM ficar pronta para conexão SSH..."
echo "Aguarde 10 segundos para a VM ficar pronta estável"

sleep 10

echo "Copiando o script instalar-dockerVM.sh para a VM..."
scp -o StrictHostKeyChecking=no instalar-dockerVM.sh $USERNAME@$PUBLIC_IP:/home/$USERNAME/

echo "Executando o script na VM para instalar Docker..."
ssh -o StrictHostKeyChecking=no $USERNAME@$PUBLIC_IP "chmod +x instalar-dockerVM.sh && ./instalar-dockerVM.sh"

echo "--------------------------------"
echo "🔗 Acesse a VM via SSH: ssh $USERNAME@$PUBLIC_IP"
echo "Senha: $PASSWORD"
