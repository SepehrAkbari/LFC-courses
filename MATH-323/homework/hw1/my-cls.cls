%%%%%%%%%%
%% SETUP
%%%%%%%%%%

\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{sepehr-temp}[2025/05/01 sepehr-temp LaTeX class]
\LoadClass[10pt]{article}
\RequirePackage[top=1in, bottom=1in, left=0.75in, right=0.75in, headheight=13.6pt]{geometry}

%%%%%%%%%%
%% PACKAGES & IMPORTS
%%%%%%%%%%

\RequirePackage[p,osf]{cochineal}
\RequirePackage{ulem}
\RequirePackage{algpseudocode}
\RequirePackage{algorithm, algorithmicx}
\RequirePackage{amsmath,amssymb,amsthm}
\RequirePackage{mathtools}
\RequirePackage{enumitem}
\RequirePackage{fancyhdr}
\RequirePackage[hidelinks]{hyperref}
\RequirePackage[explicit]{titlesec}
\RequirePackage{lastpage}
\RequirePackage{tikz}
\RequirePackage{pgfplots}
\RequirePackage{xparse}
\RequirePackage{environ}
\RequirePackage{extramarks}


\usepackage{fancyhdr}
\usepackage{amsmath}
\usepackage{amsthm}
\usepackage{amsfonts}
\usepackage{tikz}
\usepackage{algorithm}
\usepackage{algpseudocode}
\usepackage{xparse}

\RequirePackage{xcolor}
\definecolor{sec-blue}{HTML}{1F77B4}
\definecolor{sec-orange}{HTML}{FF7F0E}
\definecolor{sec-red}{HTML}{A11C05}
\definecolor{sec-yellow}{HTML}{EDE379}

\pgfplotsset{compat=1.18}
\mathtoolsset{showonlyrefs}

%%%%%%%%%%
%% TITLE / HEADER / FOOTER
%%%%%%%%%%

\newcommand*{\coursenumber}[1]{\newcommand{\@coursenumber}{#1}}
\newcommand*{\coursetitle}[1]{\newcommand{\@coursetitle}{#1}}

\renewcommand{\maketitle}{
    \begin{center}
        \large{\textbf{\@coursenumber: \@coursetitle}} \\
        \large{\textbf{\@title}} \\
        \bigskip
        \large{\textit{\@author}} |
        \IfNoValueF{\@date}{
            \large{\@date}
        }
    \end{center}
}

\fancypagestyle{firststyle}
{
  \fancyhf{}
  \cfoot{\thepage\ of \pageref{LastPage}}
  \renewcommand{\headrulewidth}{0pt}
}

\fancypagestyle{nonfirststyle}
{
  \fancyhf{}
  \lhead{\textbf{\@coursenumber: \@title{}}}
  \rhead{\@author{}}
  \cfoot{Page \thepage\ of \pageref{LastPage}}
  \lfoot{\firstxmark}   % <-- shows top-of-page mark
  \rfoot{\lastxmark}    % <-- shows bottom-of-page mark
}
\pagestyle{nonfirststyle}

\setlength{\parindent}{0pt}

\newcommand{\enterContinuationMark}[1]{
  \nobreak\extramarks{}{#1 continued on next page\ldots}
  \nobreak\extramarks{#1 (continued)}{}
}


%%%%%%%%%%
%% SECTIONS
%%%%%%%%%%

\renewcommand\thesubsection{(\alph{subsection})}

\titleformat{\section}{\Large\bfseries}{}{0em}{#1}
\titleformat{\subsection}{\large\bfseries}{}{0em}{#1}

\NewDocumentCommand{\psection}{ m m }{
  \section*{\Large{#2\quad #1}}
}

\NewDocumentEnvironment{problem}{ o }{
  \IfValueTF{#1}
    {\section*{Problem #1} \enterContinuationMark{Problem #1}}
    {\section*{Problem} \enterContinuationMark{Problem}}
  \setcounter{subsection}{0}
}{}


\NewDocumentEnvironment{solution}{ o }{
  \IfValueTF{#1}
    {\subsection*{Solution to Problem #1} \enterContinuationMark{Solution to Problem #1}}
    {\subsection*{Solution} \enterContinuationMark{Solution}}
  \setcounter{subsubsection}{0}
}{}

\RenewDocumentEnvironment{solution}{ o }{%
  \IfValueTF{#1}
    {\subsection*{\color{sec-blue}Solution to Problem #1} \enterContinuationMark{Solution to Problem #1}}
    {\subsection*{\color{sec-blue}Solution} \enterContinuationMark{Solution}}%
  \color{sec-blue}%
  \setcounter{subsubsection}{0}%
}{}


\NewDocumentEnvironment{subpart}{ o }{
  \subsection{Part \thesubsection\IfValueT{#1}{: #1}}
  \enterContinuationMark{Part \thesubsection\IfValueT{#1}{: #1}}
}{}


%%%%%%%%%%
%% MATH 
%%%%%%%%%%

\newcommand{\bigo}[1]{\ensuremath{\mathcal{O}(#1)}}
\newcommand{\softo}[1]{\widetilde{\bigO{#1}}}
\newcommand{\bigtheta}[1]{\ensuremath{\Theta(#1)}}
\newcommand{\bigomega}[1]{\ensuremath{\Omega(#1)}}
\newcommand{\littleo}[1]{\ensuremath{o}(#1)}
\newcommand{\littleomega}[1]{\ensuremath{\omega}(#1)}
\newcommand{\alg}[1]{\textsc{\bfseries \footnotesize #1}}
\newcommand{\deriv}[1]{\frac{\mathrm{d}}{\mathrm{d}x} (#1)}
\newcommand{\pderiv}[2]{\frac{\partial}{\partial #1} (#2)}
\newcommand{\dx}{\mathrm{d}x}
\newcommand{\E}{\mathrm{E}}
\newcommand{\Var}{\mathrm{Var}}
\newcommand{\Cov}{\mathrm{Cov}}
\newcommand{\Bias}{\mathrm{Bias}}

%%%%%%%%%%
%% COLORING
%%%%%%%%%%

\newcommand{\highlightedtext}[3]{\colorbox{#1}{\texttt{\color{#2} #3}}}

\newcommand{\taggedcomment}[3]{
  \highlightedtext{#1}{white}{#2}
  \highlightedtext{white}{#1}{#3}
}

\newcommand{\coloredtext}[2]{
    \textcolor{#1}{#2}
}

\newcommand{\note}[1]{\taggedcomment{sec-red}{NOTE}{#1}}
\newcommand{\remark}[1]{\taggedcomment{sec-orange}{REMARK}{#1}}

\newcommand{\ans}[1]{\coloredtext{sec-blue}{#1}}