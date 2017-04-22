;;Se utiliza la un tablero de 7x6. 6 listas de 7 elementos cada una.
(setq tablero
      '(
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
        (0 0 0 0 0 0 0)
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
;;Funcion que regresa el conjunto de subListas de 4 elementos de [thisRow], se usa para la heuristica horizontal
(defun f_subLines (thisRow)
  (setq setList '())
  (loop
    for x from 0 to 3
    do
    (setq setList (append setList (list (f_subList thisRow x (+ 3 x)))))
    )
(return-from f_subLines setList)
)
;;Funcion heuristica horizontal, recibe listas de 4 elementos [listCuatro] y el identificador del jugador [player]
(defun f_HeuristicaHorizontal (listCuatro player)
(setq numSeguidos 0)
  (cond
   ((member (* -1 player) listCuatro)
    (return-from f_HeuristicaHorizontal 0)
    )
   ((= 3 (count player listCuatro))
    (return-from f_HeuristicaHorizontal 3)
    )
   (t
    (loop
      for x from 0 to 3
      do
      (if (= (nth x listCuatro) 0) (return-from f_HeuristicaHorizontal numSeguidos) (setq numSeguidos (+ 1 numSeguidos)))
      )
    )
   )
(return-from f_HeuristicaHorizontal numSeguidos)  
)
;;funcion que cuenta y pondera las horizontales de una fila, 
;;[thisSetList] son las listas de cuatro elementos que existen en un row y [player] es el identificador del jugador
(defun f_cuentaHorizontal ( thisSetList player)
(setq suma 0)
(loop
  for  listCuatro in thisSetlist
  do
  (setq aux (f_HeuristicaHorizontal listCuatro player))
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
  (setq aux (f_HeuristicaHorizontal (reverse listCuatro) player))
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
;;Debug
(print (f_cuentaHorizontal (f_subLines '(0 1 -1 0 1 1 1)) 1))