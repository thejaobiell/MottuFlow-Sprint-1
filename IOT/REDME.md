# MottuFlow - IoT

## Link do Pitch e GitHub

* 🎥 Pitch: [https://www.youtube.com/watch?v=ipaQ8kzhdf8](https://www.youtube.com/watch?v=ipaQ8kzhdf8)
* 💻 GitHub: [https://github.com/thejaobiell/MottuFlow-Sprint-1/tree/main](https://github.com/thejaobiell/MottuFlow-Sprint-1/tree/main)

---

## Detecção de Marcadores ArUco e Estimativa de Distância

Este script Python utiliza a biblioteca OpenCV para detectar marcadores ArUco a partir de uma fonte de vídeo (webcam ou arquivo de vídeo) e estimar a distância entre a câmera e os marcadores detectados. Ele também filtra os marcadores com base em um limite de distância e imprime os IDs dos marcadores que estão dentro desse limite.

### Funcionalidades

* Detecta marcadores ArUco do dicionário `DICT_6X6_250`.
* Desenha os contornos dos marcadores detectados e seus IDs no feed de vídeo.
* Estima a pose (rotação e translação) de cada marcador.
* Calcula e exibe a distância da câmera para cada marcador.
* Filtra os marcadores que estão além de um `DISTANCE_THRESHOLD` (limite de distância) especificado.
* Imprime no console os IDs dos marcadores que estão dentro do limite de distância.
* Exibe uma mensagem simulada "LED ON" quando o marcador com ID 1 é detectado dentro do limite de distância.

---

## Pré-requisitos

Você precisará ter o Python instalado, juntamente com:

* **OpenCV (cv2)**
* **NumPy**
* **google.colab.patches** (opcional, se estiver usando o Google Colab)

### Instalação:

```bash
pip install opencv-python numpy
```

---

## Configuração

Antes de rodar o script, ajuste:

* `VIDEO_PATH`: `0` para webcam, ou o caminho para um vídeo/imagem.
* `REAL_MARKER_SIZE`: Tamanho real do marcador em metros (ex: 0.05 para 5cm).
* `DISTANCE_THRESHOLD`: Distância máxima em metros para considerar o marcador "próximo".
* `camera_matrix` e `dist_coeffs`: Parâmetros de calibração da sua câmera.

---

## Como Usar

1. Modifique os parâmetros no script conforme necessário.
2. Execute com:

```bash
python nome_do_seu_script.py
```

Ou execute a célula no Google Colab.

---

## Saída Esperada

* Feed de vídeo/imagem com marcadores ArUco destacados.
* Distância exibida abaixo de cada marcador detectado.
* IDs dos marcadores próximos impressos no console.
* Mensagem “LED ON para marcador 1” se o ID 1 estiver próximo.

---

## Observações

* Use `DICT_6X6_250` ou altere para o dicionário ArUco que você estiver utilizando.
* A acurácia da distância depende de uma calibração adequada da câmera.
* Imagens estáticas serão processadas uma única vez.

---

Se quiser, posso formatar isso em PDF ou README.md também. Deseja isso?
