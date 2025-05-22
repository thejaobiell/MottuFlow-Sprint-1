#!/bin/bash

# ESTE ARQUIVO FAZ PARTE DO PROJETO MOTTUFLOW 
# DISCIPLINA: DEVOPS TOOLS & CLOUD COMPUTING - Feli
# ALUNOS:
# - João Gabriel Boaventura Marques e Silva RM554874 | 2TDSB-2025
# - Leo Motta Lima RM557851 | 2TDSB-2025
# - Lucas Leal das Chagas RM551124 | 2TDSB-2025 

set -euo pipefail

RG_NAME="rg-mottuflow"

echo "Atenção! Isso irá excluir o grupo de recursos '$RG_NAME' e todos os recursos dentro dele."
read -p "Tem certeza que deseja continuar? (s/N): " confirm

if [[ "$confirm" =~ ^[sS]$ ]]; then
    echo "Iniciando a exclusão do grupo de recursos: $RG_NAME"
    az group delete -n $RG_NAME --yes --no-wait
    echo "Exclusão iniciada. Isso pode levar alguns minutos..."
else
    echo "Operação cancelada."
fi
