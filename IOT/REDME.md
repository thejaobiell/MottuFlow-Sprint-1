# Link do pitch e github

* https://youtu.be/dQn7y51lCtU
* https://github.com/thejaobiell/MottuFlow-Sprint-1/tree/main#

# Detecção de Marcadores ArUco e Estimativa de Distância

Este script Python utiliza a biblioteca OpenCV para detectar marcadores ArUco a partir de uma fonte de vídeo (webcam ou arquivo de vídeo) e estimar a distância entre a câmera e os marcadores detectados. Ele também filtra os marcadores com base em um limite de distância e imprime os IDs dos marcadores que estão dentro desse limite.

## Funcionalidades

* Detecta marcadores ArUco do dicionário `DICT_6X6_250`.
* Desenha os contornos dos marcadores detectados e seus IDs no feed de vídeo.
* Estima a pose (rotação e translação) de cada marcador.
* Calcula e exibe a distância da câmera para cada marcador.
* Filtra os marcadores que estão além de um `DISTANCE_THRESHOLD` (limite de distância) especificado.
* Imprime no console os IDs dos marcadores que estão dentro do limite de distância.
* Exibe uma mensagem simulada "LED ON" quando o marcador com ID 1 é detectado dentro do limite de distância.

## Pré-requisitos

Para executar este script, você precisará ter o Python instalado, juntamente com as seguintes bibliotecas:

* **OpenCV (cv2):** Para processamento de imagem e detecção de marcadores ArUco.
* **NumPy:** Para manipulação eficiente de arrays, especialmente para a matriz da câmera e coeficientes de distorção.
* **google.colab.patches (opcional):** Se você estiver executando o código no Google Colab, `cv2_imshow` é usado para exibir imagens/vídeos. Se estiver executando localmente, você pode precisar ajustar para `cv2.imshow`.

## Instalação

1.  **Instale o Python:** Se ainda não o tiver, baixe e instale a versão mais recente do Python em [python.org](https://www.python.org/).

2.  **Instale as bibliotecas necessárias:**
    Abra seu terminal ou prompt de comando e execute o seguinte comando pip:
    ```bash
    pip install opencv-python numpy
    ```
    Se você planeja usar o Google Colab, `google.colab.patches` geralmente já está disponível.

## Configuração

Antes de executar o script, você pode precisar ajustar alguns parâmetros no início do código:

* `VIDEO_PATH`:
    * Para usar uma **webcam**, altere para `0`: `VIDEO_PATH = 0`
    * Para usar um **arquivo de vídeo**, coloque o caminho para o seu arquivo: `VIDEO_PATH = '/caminho/para/seu/video.mp4'`
    * Para usar uma **imagem estática** (como no código fornecido), coloque o caminho para a sua imagem: `VIDEO_PATH = '/content/20250520_084850.jpg'` (Note que o loop `while cap.isOpened()` processará apenas um frame se for uma imagem).

* `REAL_MARKER_SIZE`:
    * Este é o tamanho real do seu marcador ArUco em metros. **É crucial definir este valor corretamente para uma estimativa de distância precisa.** Por exemplo, se o seu marcador impresso tem 5cm x 5cm, então `REAL_MARKER_SIZE = 0.05`.

* `DISTANCE_THRESHOLD`:
    * Define a distância máxima (em metros) dentro da qual os marcadores serão considerados "próximos". Marcadores além desta distância serão detectados, mas seus IDs não serão impressos na lista filtrada.

* `camera_matrix` e `dist_coeffs`:
    * Estes são os parâmetros intrínsecos da sua câmera (matriz da câmera e coeficientes de distorção). Os valores fornecidos no script são exemplos.
    * **Para uma estimativa de pose e distância precisas, você deve calibrar sua câmera** e usar os valores resultantes aqui. O OpenCV fornece funcionalidades para calibração de câmera. Se você usar os valores padrão e uma câmera diferente, a precisão da distância pode ser comprometida.

## Como Usar

1.  **Modifique os parâmetros** no script conforme descrito na seção "Configuração", especialmente `VIDEO_PATH` e `REAL_MARKER_SIZE`.
2.  **Execute o script Python:**
    ```bash
    python nome_do_seu_script.py
    ```
    (Substitua `nome_do_seu_script.py` pelo nome real do seu arquivo Python).
    Se estiver usando o Google Colab, execute a célula de código.

## Saída Esperada

* Uma janela de vídeo (ou imagem, se `VIDEO_PATH` for uma imagem) aparecerá mostrando o feed da câmera.
* Marcadores ArUco detectados terão seus contornos e IDs desenhados sobre eles.
* A distância estimada para cada marcador detectado (dentro do `DISTANCE_THRESHOLD`) será exibida abaixo do marcador no formato "ID: [id] Dist: [distancia]m".
* No console (ou na saída da célula do Colab), você verá:
    * Uma lista de IDs dos marcadores que estão dentro do `DISTANCE_THRESHOLD`.
    * Uma mensagem "LED ON para marcador 1 (dentro do limite de distância)!" se o marcador com ID 1 estiver entre os detectados dentro do limite.
    * Uma mensagem indicando que nenhum marcador foi detectado dentro do limite, se for o caso.

## Observações

* O dicionário ArUco usado é `DICT_6X6_250`. Se você estiver usando marcadores de um dicionário diferente, precisará alterar `cv2.aruco.getPredefinedDictionary(cv2.aruco.DICT_6X6_250)`.
* A precisão da estimativa de distância depende fortemente da calibração correta da câmera e da medição precisa do `REAL_MARKER_SIZE`.
* Se estiver usando uma imagem estática como entrada, o script processará essa imagem e provavelmente terminará, pois `cap.read()` retornará `False` após o primeiro frame. Para processamento contínuo de vídeo ou webcam, o loop `while` funcionará como esperado.
