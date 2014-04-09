 (defn factorial
"Calculates ! of any #"
[x]
  (if (<= x 1) 1)
  (* x (factorial (- x 1)))
)

(factorial 2)