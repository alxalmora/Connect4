;;Se utiliza la un tablero de 7x6. 6 listas de 7 elementos cada una.
(setq tablero
      '(
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 1 0)
        (0 0 0 1 1 -1 0)
        (0 0 0 1 -1 -1 0)
        )
)
;; funcion que hace un movimiento con el tablero actual, el indice donde entra la nueva ficha y que 'jugador' tira.
;;params: tablero, indice [0-6], player
(defun f_makeMove (thisTablero index player)
  (setq newTablero (copy-list thisTablero))
  (dotimes (n 6)
       (cond
        ((= (nth index (nth (- 5 n) newTablero)) 0)
         (setq row (copy-list (nth (- 5 n) newTablero)))
         (setf (nth index row) player)
         (setf (nth (- 5 n) newTablero) row)
         ;;(f_beautyPrint newTablero)
         (return-from f_makeMove newTablero)
         )
       )
   )
  (return-from f_makeMove '())
)
;;Imprime un tablero de forma ordenada. 
(defun f_beautyPrint (thisTablero)
  (dotimes (n 6)
    (print (nth n thisTablero))
  )
)
;;Funcion que regresa una sublista de [lst] desde [n] hasta [m]
(defun f_subList(lst n m)
  (setq retList '())
  (loop
    for x from n to m
    do
    (setq retList (append retList (list (nth x lst))))
    )
(return-from f_subList retList)
)
;;Funcion que cuenta los seguidos recibe listas de 4 elementos [listCuatro] y el identificador del jugador [player]
(defun f_cuentaSeguidos (listCuatro player)
(setq numSeguidos 0)
  (cond
   ((member (* -1 player) listCuatro)
    (return-from f_cuentaSeguidos 0)
    )
   ((= 4 (count 0 listCuatro))
    (return-from f_cuentaSeguidos 0)
    )
   ((= 3 (count player listCuatro))
    (return-from f_cuentaSeguidos 3)
    )
   (t
    (loop
      for x from 0 to 3
      do
      (if (= (nth x listCuatro) 0) (return-from f_cuentaSeguidos numSeguidos) (setq numSeguidos (+ 1 numSeguidos)))
      )
    )
   )
(return-from f_cuentaSeguidos numSeguidos)  
)
;;funcion que cuenta y pondera las horizontales de una fila, 
;;[thisSetList] son las listas de cuatro elementos que existen en un row y [player] es el identificador del jugador
(defun f_cuentaHorizontal ( thisSetList player)
(setq suma 0)
(loop
  for  listCuatro in thisSetlist
  do
  (setq aux (f_cuentaSeguidos listCuatro player))
  (cond
   ((= aux 1)
    (setq suma (+ 1 suma))
   )
   ((= aux 2)
    (setq suma (+ 10 suma))
    )
   ((= aux 3)
    (setq suma (+ 100 suma))
    )
   ((= aux 4)
    (setq suma (+ 100000 suma))
    )
   )
  (setq aux (f_cuentaSeguidos (reverse listCuatro) player))
    (cond
   ((= aux 1)
    (setq suma (+ 1 suma))
   )
   ((= aux 2)
    (setq suma (+ 10 suma))
    )
   )
)
(return-from f_cuentaHorizontal suma)
)
;;funcion que extrae la [index] columna de un tablero [thisTablero] y la regresa como una lista
(defun f_makeColumn (thisTablero index)
(setq column '())
(loop
  for i from 0 to 5
  do
  (setq column (append column (list (nth index (nth (- 5 i) thisTablero)))))
)
(return-from f_makeColumn column)
)
;;funcion que calcula la heuristica de un conjunto de sublineas de 4 [thisSetList] con el indicador [player]
(defun f_cuentaVertical (thisSetList player)
(setq suma 0)
(loop
  for  listCuatro in thisSetlist
  do
  (setq aux (f_cuentaSeguidos listCuatro player))
  (cond
   ((= aux 1)
    (setq suma (+ 1 suma))
   )
   ((= aux 2)
    (setq suma (+ 10 suma))
    )
   ((= aux 3)
    (setq suma (+ 100 suma))
    )
   ((= aux 4)
    (setq suma (+ 100000 suma))
    )
   )
)
(return-from f_cuentaVertical suma)
)
;;funcion que regresa las sublistas de 4 en orden de una lista [thisList]
(defun f_sub4Lines(thisList)
(setq size (list-length thisList))
(setq setList '())
(cond 
((= size 4)
 (setq setList (list thisList))
 (return-from f_sub4Lines (list thisList))
)
((< size 4)
(print "error")
)
)
(loop
    for x from 0 to (- size 4)
    do
    (setq setList (append setList (list (f_subList thisList x (+ 3 x)))))
    )
(return-from f_sub4Lines setList)
)

;;Funcion que regresa una lista con las diagonales del tablero, mayores a 4
(defun f_getDiagonales (thisTablero)
(setq diagonal 
(list
 (list (nth 0 (nth 3 thisTablero)) (nth 1 (nth 2 thisTablero)) (nth 2 (nth 1 thisTablero)) (nth 3 (nth 0 thisTablero)))
 (list (nth 0 (nth 4 thisTablero)) (nth 1 (nth 3 thisTablero)) (nth 2 (nth 2 thisTablero)) (nth 3 (nth 1 thisTablero)) (nth 4 (nth 0 thisTablero)))
 (list (nth 0 (nth 5 thisTablero)) (nth 1 (nth 4 thisTablero)) (nth 2 (nth 3 thisTablero)) (nth 3 (nth 2 thisTablero)) (nth 4 (nth 1 thisTablero)) (nth 5 (nth 0 thisTablero)))
 (list (nth 1 (nth 5 thisTablero)) (nth 2 (nth 4 thisTablero)) (nth 3 (nth 3 thisTablero)) (nth 4 (nth 2 thisTablero)) (nth 5 (nth 1 thisTablero)) (nth 6 (nth 0 thisTablero)))
 (list (nth 2 (nth 5 thisTablero)) (nth 3 (nth 4 thisTablero)) (nth 4 (nth 3 thisTablero)) (nth 5 (nth 2 thisTablero)) (nth 6 (nth 1 thisTablero)))
 (list (nth 3 (nth 5 thisTablero)) (nth 4 (nth 4 thisTablero)) (nth 5 (nth 3 thisTablero)) (nth 6 (nth 2 thisTablero)))
 (list (nth 0 (nth 0 thisTablero)) (nth 1 (nth 1 thisTablero)) (nth 2 (nth 2 thisTablero)) (nth 3 (nth 3 thisTablero)) (nth 4 (nth 4 thisTablero)) (nth 5 (nth 5 thisTablero)))
 (list (nth 1 (nth 0 thisTablero)) (nth 2 (nth 1 thisTablero)) (nth 3 (nth 2 thisTablero)) (nth 4 (nth 3 thisTablero)) (nth 5 (nth 4 thisTablero)) (nth 6 (nth 5 thisTablero)))
 (list (nth 2 (nth 0 thisTablero)) (nth 3 (nth 1 thisTablero)) (nth 4 (nth 2 thisTablero)) (nth 5 (nth 3 thisTablero)) (nth 6 (nth 4 thisTablero)))
 (list (nth 3 (nth 0 thisTablero)) (nth 4 (nth 1 thisTablero)) (nth 5 (nth 2 thisTablero)) (nth 6 (nth 3 thisTablero)))
 (list (nth 0 (nth 1 thisTablero)) (nth 1 (nth 2 thisTablero)) (nth 2 (nth 3 thisTablero)) (nth 3 (nth 4 thisTablero)) (nth 4 (nth 5 thisTablero)))
 (list (nth 0 (nth 2 thisTablero)) (nth 1 (nth 3 thisTablero)) (nth 2 (nth 4 thisTablero)) (nth 3 (nth 5 thisTablero)))
)
)
(return-from f_getDiagonales diagonal)
)
;;funcion que calcula las diagonales, utiliza f_cuenta Horizontal
(defun f_cuentaDiagonal (thisSetList player)
  (return-from f_cuentaDiagonal (f_cuentaHorizontal thisSetList player))
)
;;funcion que calcula el costo del tablero, funcion heuristica utilizada.
(defun f_heuristicaTablero (thisTablero player)
(setq suma 0)
(loop
  for i from 0 to 6
  do
   (setq suma (+ suma (f_cuentaVertical (f_sub4Lines (f_makeColumn thisTablero i)) player)))
)
(loop
 for i from 0 to 5
  do
  (setq suma (+ suma (f_cuentaHorizontal (f_sub4Lines (nth i thisTablero)) player)))
)
(setq diagonales (f_getDiagonales thisTablero))
(loop
  for i from 0 to 11
  do
  (setq suma (+ suma (f_cuentaDiagonal (f_sub4Lines (nth i diagonales)) player)))   
)
(return-from f_heuristicaTablero suma)
)
;;Debug
;;(print  (f_sub4Lines '(0 0 0 0 0 0 0)))
;;(print (f_cuentaHorizontal (f_sub4Lines '(0 0 0 0 0 0 0)) 1))
;;(print (f_cuentaHorizontal (f_sub4Lines (nth 0 tablero)) 1))
;;(print (nth 5 tablero))
(print (f_heuristicaTablero tablero -1))