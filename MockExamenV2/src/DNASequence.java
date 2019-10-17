public class DNASequence {

	private String alphabet; // One of the String's "dna", "rna", "protein"
	private String sequence; // Sequence of letters representing nuclotides or aminoacids

	/**
	 * Constructs a new DNASequence with the given parameters
	 */
	public DNASequence(String sequence, String alphabet)  {
		this.sequence = sequence;
		this.alphabet = alphabet;
	}

	/**
	 * Constructs a new DNASequence with the same properties as parameter sequence s
	 */
	public DNASequence(DNASequence s)  {
		this.sequence = s.sequence;
		this.alphabet = s.alphabet;
	}

	// Getters
	public String getAlphabet() {
		return alphabet;
	}

	public String getSequence() {
		return sequence;
	}



	public boolean equals(Object o) {
		if (o instanceof DNASequence) {
			DNASequence s = (DNASequence) o;
			return (s.getAlphabet().equals(this.getAlphabet()) && (s.getSequence().equals(this.getSequence())));
		}
		return false;
	}

	/**
	 * Exercise #1
	 * Returns true iff the target DNASequence is a protein, that is if its
	 * alphabet is the String "protein".
	 */
	public boolean isProtein() {
		if(this.alphabet.contains("protein")) {
			return true;
		}
		
		return false;
	}

	/**
	 * Exercise #2
	 * Returns true if and only if the target DNASequence contains at least one 
	 * or more copies of the parameter's (DNASequence s2) sequence.
	 */
	public boolean contains(DNASequence s2) {
		if(this.sequence.contains(s2.sequence)) {
			return true;
		}
		return false;
	}

	/**
	 * Exercise #3
	 * Returns a NEW DNASequence consisting of the concatenation of the target DNASequence
	 * with the parameter DNASequence s2.  The alphabet of the result is the same as the
	 * alphabet of the target sequence.
	 */
	public DNASequence append(DNASequence s2) {
		
		String newSequence = this.sequence + s2.sequence;
		
		return new DNASequence(newSequence,this.alphabet);
	}

	/**
	 * Exercise #4
	 * Returns the longest DNASequence in the give array of sequences
	 * If the list contains two or more sequences with the same longest length
	 * the method should return the first such sequence in the array.
	 * The array may contain some empty (null) slots, but only at the end.
	 * If the list of sequences is empty returns null
	 */
	public static DNASequence longestSequence(DNASequence[] sequences) {
		DNASequence longSequence= sequences[0];
		if(sequences.length==0)
			return null;
		else{

			for(DNASequence newS: sequences)
				if(newS==null)
					break;
				else if(newS.sequence.length()> longSequence.sequence.length())
					longSequence = newS; 
		}
		return longSequence;
	}

	/**
	 * Exercise #5
	 * Returns a new DNASequence containing the concatenation of all the
	 * DNASequences in the given array.
	 * The array may contain some empty (null) slots, but only at the end.
	 * Returns a DNASequence object with an empty sequence if the list is empty
	 * or all sequences are empty
	 * HINT: You may find the append method useful for this problem
	 */
	public static DNASequence concatenate(DNASequence[] list) {
		DNASequence newSequence = new DNASequence("","dna");
		if(list.equals(null))
			return null;
		if(list.length==0)
			return new DNASequence("","dna");
		else{
			for(DNASequence s: list) {
				if(s==null)
					break;
				if(s.sequence!="")
					newSequence=newSequence.append(s);
			}

		}
		return newSequence;
	}


	/**
	 * Exercise #6
	 * Returns true if and only if the target sequence exists in the given 
	 * array of sequences.
	 * The array may contain some empty (null) slots, but only at the end.
	 * Stops searching as soon as the target sequence if found.
	 */
	public boolean exists(DNASequence[] list) {
		for(DNASequence newS: list) {
			if(newS==null)
				break;
			if(this.sequence.equals(newS.sequence))
				return true;
		}
		return false; //Dummy return
	}

	/**
	 * Exercise #7
	 * Adds the target DNASequence at the first empty (null) position
	 * of the given array of DNASequences
	 * If the array has no empty positions the method does nothing
	 * Returns the modified array of DNASequence's
	 */
	public DNASequence[] addSequence(DNASequence[] sequences) {
		if(sequences != null)
			for(int i=0;i<sequence.length();i++){

				if(sequences[i]==null) {
					sequences[i]= this;
					return sequences;
				}
			}
		return new DNASequence[0];
	}

	/**
	 * Exercise #8
	 * Returns true if and only iff some DNAsequence in the array is completely 
	 * contained within (i.e. is a subsequence of) another of the DNASequence's 
	 * in the array.
	 * The array may contain some empty (null) slots, but only at the end.
	 * HINT: The contains instance method could be useful
	 */ 
	public static boolean someCompletelyContained(DNASequence[] list) {
		for(int i=0;i<list.length-1;i++) {
			for(int j=i+1;j<list.length;j++) {
				if(list[i]==null || list[j]==null) {
					break;
				}
				System.out.println(list[i].contains(list[j]));
				if(list[i].contains(list[j]) || list[j].contains(list[i]) ) {
					return true;
				}
			}
		}		
		return false;
	}
}
