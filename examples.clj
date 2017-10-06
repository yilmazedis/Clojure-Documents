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

;(println (mkList (readFile "document1.txt")))
;(println (mkList (readFile "dictionary1.txt")))

(defn matchWords [w1 w2]
  (def matched 0)
  (def len_w1 (count w1))
  (def len_w2 (count w2))
  (dotimes [n1 len_w1]
      (dotimes [n2 len_w2]
          (if (= (nth w1 n1) (nth w2 n2)) (def matched (inc matched)))))
  (let [] matched))

;(println (matchWords (mkList (readFile "document2.txt")) (mkList (readFile "dictionary1.txt"))))

(defn ints-from [n]
(cons n (lazy-seq (ints-from (dec n)))))

;(println (reverse (take 5 (ints-from 5))))
;(println (reverse (take 4 (ints-from 5))))
;(println (reverse (take 3 (ints-from 5))))
;(println (reverse (take 2 (ints-from 5))))


;(println (distinct [1 2 3 4 4 1 1]))

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
	(distinct (map concat  (tail mySeq)  (init mySeq) )))

;(println "init" (init (list 0 1 2 3 4)))

;(println "tail" (tail (list 0 1 2 3 4)))

;(println (concatMapList (list 1 2 3)))

(defn permutations [perm-set]
  (if (empty? perm-set)
    (list ())
    (mapcat
     (fn [[x & xs]] (map #(cons x %) (permutations xs)))
     (concatMapList perm-set))))

 (println (permutations (list 1 2 3)))
