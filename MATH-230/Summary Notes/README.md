###### This is not all the topics covered. But is a summary of key things to know. Its a good source to review before exams.

## Summary Notes

### Table of Contents

- [Boolean Algebra](#boolean-algebra)

- [Proof By Contradiction](#proof-by-contradiction)

- [Proof By Induction](#proof-by-induction)

- [Proof By Smallest Counterexample](#proof-by-smallest-counterexample)

- [Proof By Strong Induction](#proof-by-strong-induction)

- [Pigeonhole Principle](#pigeonhole-principle)

- [Relations](#relations)

- [Functions](#functions)

- [Partially Ordered Sets](#partialy-ordered-sets)

### Boolean Algebra

Commutative Law:

$$A \land B = B \land A$$
Associative Law:$$(A\land B)\land C = A \land (B \land C)$$
Distributive Law: $$A \land (B \lor C) = (A \land B) \lor (A \land C)$$
Linearity: $$A \land T = A$$ $$\neg (\neg A) = A$$
$$A \land (\neg A)=F$$

Morgan's Law: $$\neg(A\land B) = (\neg A) \lor (\neg B)$$
$$\neg(A\lor B) = (\neg A) \land (\neg B)$$


General Truth Table:

| $X$ | $Y$ | $\neg X$ | $\neg Y$ | $X\lor Y$ | $X\land Y$ | $X\rightarrow Y$ | $Y\rightarrow X$ | $X\leftrightarrow Y$ |
| :-- | --- | -------- | -------- | --------- | ---------- | ---------------- | ---------------- | -------------------- |
| T   | T   | F        | F        | T         | T          | T                | T                | T                    |
| T   | F   | F        | T        | T         | F          | F                | T                | F                    |
| F   | T   | T        | F        | T         | F          | T                | F                | F                    |
| F   | F   | T        | T        | F         | F          | T                | T                | T                    |

### Proof By Contradiction

Perform: If $n = T$, then $n\neq T$ is False.

- Lay contradiction hypotheses ($n \neq T$).
- Show why it cannot happen.
- Conclude $n = T$.

### Proof By Induction

Perform: If $n = n$, then $n+1 = n+1$ is True.

- Check the base case, for some $n$.
- Lay down the Induction Hypotheses, using the base case condition.
- Show $\forall (k = k)$, $\exists (k+1 = k+1)$.

### Proof By Smallest Counterexample

Perform: If $n=n$ for $n \ge m$, then $n-1 = n-1$ is True.

- Lay contradiction hypotheses ($n \ne T$).
- Check the base case, for some $n$ that does not work, usually $n_0 \ge m+1$.
- Show that $n_0 - 1 = n_0 - 1$.
- From the results, show $n_0 \ge m+1$ is true, meaning there is no contradicting case.

### Proof By Strong Induction

Perform: If $n=n$ for $n \le k$, then $n=n$ for $n \le k+1$.

- Check the base case, for some $n$.
- State the assumption is true, up until some $k$.
- Prove the assumption holds at $k+1$.

### Pigeonhole Principle

Perform: Let there be $n$ pigeons, and $m$ pigeonholes. If $n > m$, then at least one pigeonhole has two contain two pigeons.

- Identify pigeons – the object being assigned ($n$).
- Identify pigeonholes – the locations available ($m$).
- Show $n > m$.
- Conclude.

### Relations

$A$, $B$, $C$ is a set, and $R$ is the set of relations on them. 
Let $a \in A$, $b \in B$, and $c \in C$. We'll have:

Reflexivity: $$\forall a \in A \implies a \sim a$$
Symmetry: $$\forall a \sim b \implies \exists b \sim a$$
Antisymmetry: $$\forall a \sim b, \exists b \sim a \iff a=b $$
Transitivity: $$\exists a \sim b, \exists b \sim c \implies a \sim c$$

Equivalence Relation, is a relation that is Reflexive, Symmetric, and Transitive. 

Equivalence Class: $$[a] = \{a, \forall b \in a \sim b\}$$

### Functions

Let $f: A \rightarrow B$ and $g: B \rightarrow C$.

Then:

$$g \circ f: A \rightarrow C$$
$$|\operatorname{Im}f| \subset B$$

Injective Functions (one-to-one): 

- $\forall a, b \in A$, $f(a) = f(b) \implies a = b$.
- $|\operatorname{Im}f|=|A|$.
- $|\operatorname{dom}f| \le |B|$.

Surjective Functions (onto):

- $\forall b \in B$, $\exists a \in A$ such that $f(a)=b$.
- $|\operatorname{dom}f| \ge |B|$.
- $|\operatorname{Im}f| = |B|$.

Inverse Functions ($f^{-1}$):

- if $f = \{(1,2), (2,5)\}$, $f^{-1} = \{(2,1), (5,2)\}$

Counting Functions:

- Let $|A|=m$ and $|B| = n$.
- Overall: $n^m$.
- Injectives: $\frac{n!}{(n-m)!}$.
- Surjective: counting partitions.

### Partially Ordered Sets

A relation is partially ordered when its Reflexive, Antisymmetric, and Transitive. 

```
	d
   / 
  c   f
 /   / 
b   e
 \ /
  a
```

Longest Chain: $\{a,b,c,d\}$
Longest Antichain: $\{b,e\}$
Width: 2
Length: 4

Rules:

$$x < y: x \le y,x \ne y$$
$$x \ge y: y \le x$$
$$x > y: y \le x,x \ne y$$

A total/linear order poset must have width of 1.

Two posets are isomorphic if $(P,Q)$:

- $|P|=|Q|$.
- Their Hasse Diagram is the same shape.
- $f:P\rightarrow Q$ is a bijection.

