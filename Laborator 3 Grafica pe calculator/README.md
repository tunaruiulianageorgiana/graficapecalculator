Acest folder conține:
- Documentația proiectului si printscreen-uri (fișier Word)
- Codul aplicației Android (arhivă .zip).

În cadrul acestui proiect am realizat o aplicație Android care utilizează OpenGL pentru a afișa un obiect 3D, mai exact un cub.
Am creat o clasă principală (BouncyCubeActivity) în care am înlocuit layout-ul clasic XML cu un GLSurfaceView, responsabil pentru randarea graficii.
De asemenea, am implementat un renderer (CubeRenderer) care controlează modul în care cubul este desenat și animat pe ecran.
Cubul este translat și rotit în timp real, folosind funcții specifice OpenGL, oferind astfel o animație fluidă.
