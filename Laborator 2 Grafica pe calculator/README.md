Acest folder conține:
- Documentația proiectului si printscreen-uri (fișier Word)
- Codul aplicației Android (arhivă .zip)

Aplicația afișează o culoare folosind OpenGL (GLSurfaceView).Acest proiect are ca scop realizarea unei aplicații Android care utilizează biblioteca OpenGL ES pentru a desena și anima un obiect grafic simplu.
Aplicația creează un pătrat 2D definit prin coordonate de tip vertex, căruia i se aplică culori diferite pe fiecare colț, rezultând un efect de gradient. Pătratul este randat folosind clasa GLSurfaceView și un renderer personalizat.
Prin intermediul clasei SquareRenderer, pătratul este animat pe axa verticală, folosind o funcție sinusoidală pentru a crea o mișcare fluidă de sus în jos. Această animație este actualizată continuu în metoda onDrawFrame.
Proiectul este structurat în trei clase principale:
- BouncySquareActivity – gestionează interfața și inițializează rendererul OpenGL;
- SquareRenderer – controlează randarea și animația obiectului;
- Square – definește geometria și culorile pătratului.
Aplicația demonstrează concepte de bază din grafica pe calculator, precum utilizarea bufferelor, transformările geometrice și animația în timp real.
