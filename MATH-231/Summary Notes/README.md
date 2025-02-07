###### This is not all the topics covered. But is a summary of key things to know. Its a good source to review before exams.

## Summary Notes

### Table of Contents (incomplete)

- [Fields](#fields)

- [Vector Spaces](#vector-spaces)

- [Supspaces](#subspaces)

- [Theorems](#theorems)

### Fields

A field is a set $F$ with two operations, addition and multiplication, satisfying certain axioms.

Key Properties:

A field $F$ must satisfy:

1. Closure under addition and multiplication:

$$
a,b \in \mathbb{F} \text{ then } a+b\in \mathbb{F}
$$

$$
a,b \in \mathbb{F} \text{ then } a \times b\in \mathbb{F}
$$

2. Associativity:

$$(a + b) + c = a + (b + c) $$

$$(a \cdot b) \cdot c = a \cdot (b \cdot c)$$

5. Commutativity:

$$a + b = b + a $$

$$ a \cdot b = b \cdot a$$

8. Identity Elements:

- Additive identity:
  
$$a + 0 = a, \forall a \in \mathbb{F}$$

- Multiplicative identity:

$$a \times 1 = a, \forall a \in \mathbb{F}$$

5. Inverses:

- Additive inverse:

$$a + (-a) = 0, \forall a \in \mathbb{F}$$

- Multiplicative inverse:

$$a (a^{-1}) = 1, \forall a \in \mathbb{F}$$

6. Distributivity:

$$a\cdot (b + c) = a \cdot b + a \cdot c$$

Common Examples of Fields: 

$$\mathbb{Q}, \mathbb{R}, \mathbb{C}, \mathbb{Z}_{p \text{ (where p is prime)}}, \mathbb{F}^\infty$$

To prove a set F is a field:

- Verify closure under addition and multiplication.

- Show all field axioms hold (especially existence of identities and inverses).

### Vector Spaces

A vector space over a field  $F$  is a set  $V$  with an operation of vector addition and scalar multiplication satisfying certain axioms.

Key Properties:

Let  V  be a vector space over a field  $F$ , then for all  $u, v, w \in V$  and scalars  $a, b \in F$:

1. Closure under Addition & Scalar Multiplication

$$u + v \in V, \quad a \cdot v \in V$$

2. Associativity:  

$$u + (v + w) = (u + v) + w$$

3. Commutativity:  

$$u + v = v + u$$

4. Additive Identity: 

$$\exists 0 \in V  \text{ st. }  v + 0 = v$$

5. Additive Inverse: 

$$\forall  v \in V , \exists -v \text{ st. } v + (-v) = 0$$

6. Multiplicative Identity:  

$$1v = v, \forall v \in V$$

7. Distributivity:  

$$a(v + w) = av + aw$$

$$(a + b)v = av + bv$$

8. Associativity of Scalar Multiplication:  

$$a(bv) = (ab)v$$

Examples of Vector Spaces:

- $$\mathbb{R}^n  over  \mathbb{R}$$/
- The set of all polynomials of degree at most  n  over  $$\mathbb{R}$$.
- The set of all continuous functions  $$C([a, b])$$  over  $$\mathbb{R}$$.

Proving a Set is a Vector Space:

1. Define vector addition and scalar multiplication.
2. Verify all 8 vector space axioms hold.

### Subspaces

A subspace of a vector space  $V$  is a subset  $W$  that is itself a vector space under the same operations.

Key Properties:

For  $W \subseteq V$  to be a subspace:

1. Non-emptiness:  

$$0 \in W$$

2. Closed under Addition:  

$$u, v \in W \Rightarrow u + v \in W$$


3. Closed under Scalar Multiplication:  

$$a \in F, v \in W \Rightarrow av \in W$$

Proving a Subset is a Subspace:

1. Show that  $0 \in W$.
2. Prove closure under addition and scalar multiplication.

### Theorems

#### Theorem 1.26: 

"A vector space has a unique additive identity."

**Proof:**

Suppose $0$  and  $0'$  are both additive identities in  $V$.

Then: $0 = 0 + 0'$ and $0' = 0 + 0'$, so $0 = 0'$.

#### Theorem 1.27:

"Every element in a vector space has a unique additive inverse."

**Proof:**

Suppose  $v \in V$  has two additive inverses,  $u$  and  $w$.

Then: $u = u + 0 = u + (v+w) = (u+v) + w = 0 + w = w$.

#### Theorem 1.30 and 1.31:

"$0v = 0a = 0$ for every $v \in V$ and similarly $a \in F$."

**Proof:**

$0v = (0 + 0)v = 0v + 0v$, and adding $-(0v)$ to both sides gives $0 = 0v$.

It also means because $a0 = a0 + a0$ then $a0$ is an additive identity.

#### Theorem 1.32:

"$(−1)v = -v$ for every $v \in V$."

**Proof:**

$(-1)v + v = (-1)v + 1v = (-1 + 1)v = 0v = 0$ so $(-1)v$ is the additive inverse of $v$ or written as $-v$.

#### Theorem 1.34:

#A subset $U$ of $V$ is a subspace of $V$ if and only if $U$ satisfies the following three conditions.:

additive identity: $0 \in U$.
closed under addition: $u, w \in U \implies u+w \in U$.
closed under scalar multiplication: $a \in F, u \in U \implies au \in U$.

#### Theorem 1.40:

Suppose $V_1,...,V_m$ are subspaces of V. Then $V_1+...+V_m$ is the smallest subspace of $V$ containing $V_1,...,V_m$.
