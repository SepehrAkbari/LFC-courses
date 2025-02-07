###### This is not all the topics covered. But is a summary of key things to know. Its a good source to review before exams.

## Summary Notes

### Table of Contents (incomplete)

- [Fields](#fields)

- [Vector Spaces](#vector-spaces)

- [Supspaces](#subspaces)

### Fields

A field is a set $F$ with two operations, addition and multiplication, satisfying certain axioms. 

Key Properties:

A field  $F$  must satisfy:

1. Closure under addition and multiplication.
2. Associativity: $$(a + b) + c = a + (b + c) \n (a \cdot b) \cdot c = a \cdot (b \cdot c)$$
3. Commutativity:  $$a + b = b + a ,  a \cdot b = b \cdot a$$
	4.	Identity Elements:
	•	Additive identity:  0  such that  a + 0 = a .
	•	Multiplicative identity:  1  such that  a \cdot 1 = a ,  1 \neq 0 .
	5.	Inverses:
	•	Additive inverse:  \forall a \in F, \exists (-a)  such that  a + (-a) = 0 .
	•	Multiplicative inverse:  \forall a \neq 0, \exists a^{-1}  such that  a \cdot a^{-1} = 1 .
	6.	Distributivity:  a \cdot (b + c) = a \cdot b + a \cdot c .

Common Examples of Fields:
	•	 \mathbb{Q}, \mathbb{R}, \mathbb{C}  (fields under usual addition and multiplication).
	•	Finite fields  \mathbb{Z}_p  (integers modulo  p , where  p  is prime).

Proving Something is a Field:

To prove a set  F  is a field:
	•	Verify closure under addition and multiplication.
	•	Show all field axioms hold (especially existence of identities and inverses).
	•	Example proof:  \mathbb{Z}_p  is a field (if  p  is prime).
	•	Closure follows from modular arithmetic.
	•	Inverses exist for nonzero elements because of Fermat’s theorem.