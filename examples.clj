(ns clojure.examples.example
   (:require [clojure.set :as set])
   (require [clojure.string :as str])
   (:gen-class))

(defn readFile [name]
  (clojure.string/split (slurp name) #"\s+")
  )
 
(defn mkList [vect]
  ;(println vect)
	(def reverseVect (reverse vect)) ; reverse vector
	(def newList (list)) ; Decleration empty list
	(def sizeVect (count vect)) ; vector size
	(dotimes [n sizeVect] ; Loop statement
		(def elemVect (nth reverseVect n)) ; get element of vector
		(def letters (apply list elemVect)) ; convert vector to list
		(def newList (cons letters newList))) ; add list to begining of list

	(let [] newList))

;(println "\nDocuments")
;(println (mkList (readFile "mydocument.txt")))
;(println "\nDictionary")
;(println (mkList (readFile "mydictionary.txt")))

(defn matchWords [w1 w2]
  (def matched 0)
  (def len_w1 (count w1))
  (def len_w2 (count w2))
  (dotimes [n1 len_w1]
  	
      (dotimes [n2 len_w2]
      	  
          (if (= (nth w1 n1) (nth w2 n2)) 
          	(if (= (count (nth w1 n1)) (count (nth w2 n2))) 
          		(println (nth w2 n2))))))
  
  ;matched
  )

(println (matchWords (mkList (readFile "dictionary2.txt")) (mkList (readFile "document1.txt"))))


(defn tail [listTail] 
	(def tailList (list))
	(def mList listTail)
	(def sizeList (count listTail))
	(def tailList (cons mList tailList))
	(dotimes [n sizeList]
		(def tailList (cons (rest mList) tailList))
		(def mList (rest mList))
	)
	(let [] (reverse tailList))
	)

(defn init [listInit] 
	(def initList (list))
	(def mList listInit)
	(def sizeList (count listInit))
	(def initList (cons mList initList))
	(dotimes [n sizeList]
		(def initList (cons (butlast mList) initList))
		(def mList (butlast mList))
	)
	(let [] initList)
	)

(defn concatMapList [mySeq]
	(distinct (map concat  (tail mySeq)  (init mySeq) ))
	)

;(println "init" (init (list 0 1 2 3 4)))

;(println "tail" (tail (list 0 1 2 3 4)))

;(println (concatMapList (list 1 2 3)))

(defn permutations [perm-set]
  (if (empty? perm-set)
    (list ())
    (apply concat (map
     (fn [[x & xs]]
     	(map (fn [y] 
     		(cons x y)) 
     			(permutations xs)))
     (concatMapList perm-set)))))

(defn findIndex [ch] 
	(def alfabe (list "e" "a" "n"))
	(.indexOf alfabe ch))

(defn decodeWithBruteForce []
	(def alfabe (list "e" "a" "n"))
 	(def bigList (permutations alfabe))
 	(def lenBigList (count bigList))
 	(def encodedDocument (mkList (readFile "mydocument.txt")))
 	(def tempListDis (list))
 	
 	(dotimes [n lenBigList]
 		;(println bigList)
 		(def temp (nth bigList n))
 		(println temp)

 		(dotimes [n1 (count encodedDocument)]

 			(def enDocInnList (nth encodedDocument n1))

 			(def tempList (list))
 			
 			(dotimes [n2 (count enDocInnList)]

 				(def ch (str (nth enDocInnList n2) ""))

 				(def in (findIndex ch))



 				(def tempList (cons (nth temp in) tempList))

 				;(println tempList)
 			)
 		)

 		(def tempListDis (cons tempList tempListDis))
 		;(println tempListDis)

 	)

 	;(println tempListDis)
	;(println "\nlenUpList --> " lenBigList)
	;(println alfabe)

	tempListDis
)

;(println (decodeWithBruteForce))

;(println (matchWords (mkList (readFile "mydictionary.txt")) (decodeWithBruteForce)))

;(println (deneme "n"))

;"m" "e" "r" "h" "a" "b" "n"
 ; "a" "b" "c" "d" "e" "f" "g" 
 ; "h" "i" "j" "k" "l" "m" "n" 
 ; "o" "p" "q" "r" "s" "t" "u" 
 ; "v" "w" "x" "y" "z"

