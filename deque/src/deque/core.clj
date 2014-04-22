(ns deque.core)

(defrecord Deque [front back size])

;; # Your Work

(defn make-deque
  "Create an empty deque."
  []
  (Deque. '() '() 0))

(defn deque-size
  "Return the size of a deque."
  [dq]
  (:size dq))

(defn push-front
  "Adds an element to the front of the deque."
  [dq elt]
  (let [{:keys [front back size]} dq]
    (Deque. (cons elt front) back (inc size))))

;(def test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8))

;(push-front test_deque 10)

(defn push-back
  "Adds an element to the back fo the deque."
  [dq elt]
  (let [{:keys [front back size]} dq]
  (Deque. front (cons elt back) (inc size))))

(def test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8))

(push-back test_deque 8)

(defn flip-front
  "Flip the back list to the front list, if necessary."
  [dq]
  (let [{:keys [front back size]} dq]
    (cond (empty? front)
          (Deque. (reverse back) front size)
     :else dq)))


(def test_deque (Deque. '() '(3 4) 2))

(flip-front test_deque)

(defn flip-back
  "Flip the front list to the back list, if necessary."
  [dq]
  (let [{:keys [front back size]} dq]
    (cond (empty? back)
          (Deque. back (reverse front) size)
     :else dq)))

(defn front ;peek
  "Return the front element of the deque.  May cause a flip."
  [dq]
  (let [{:keys [front back size]} dq]
  (cond (empty? front) (first (:front (flip-front dq)))
   :else (first front))))

;(front test_deque)

(defn back ;peek
  "Return the back element of the deque.  May cause a flip."
  [dq]
  (let [{:keys [front back size]} dq]
  (cond (empty? back) (first (:back (flip-back dq)))
   :else (first back))))

;(back test_deque)
   
(defn pop-front
  "Pops/dequeues an element from the front of the deque."
  [dq]
  (let [{:keys [front back size]} dq]
    (cond (= size 0) dq
       (empty? front) (Deque. (rest (:front (flip-front dq))) '() (dec size))  
       :else (Deque. (rest front) back (dec size))
          )))

;(pop-front test_deque)

(defn pop-back
  "Pops/dequeues an element from the back of the deque."
  [dq]
   (let [{:keys [front back size]} dq]
    (cond (= size 0) dq
       (empty? back) (Deque. '() (rest (:back (flip-back dq))) (dec size))
       :else (Deque. front (rest back) (dec size))
          )))

;(def test_deque (Deque. '(1 2 3 4 5 6) '(7 8) 8))
;(:size (pop-back test_deque))
