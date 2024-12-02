
**Author**: Bhavya Batta  

**Email**: [bbatt@uic.edu](mailto:bbatt@uic.edu)

**Video**: [Video Demo Link](https://uic.zoom.us/rec/share/XLlGfaZo1_dhUL4USrI3ZlMyHZQ8a19ZVihouOEf-vrPO91XjWtdm7EjSRTVkrlZ.iKwDWA6-RXz_cbam)

## Introduction

This project aims to build a Distributed Large Language Model (LLM) by leveraging the distributed computing capabilities of Hadoop and deploying it to AWS Elastic MapReduce (EMR). The main objective is to tokenize a corpus, learn vector embeddings using Word2Vec, and compute cosine similarities across token embeddings. The project showcases a complete end-to-end pipeline from tokenization to vector embedding generation, classification of cosine similarities, and deploying the workflow to AWS EMR.

## Environment

- **OS**: Mac
- **IDE**: IntelliJ IDEA 2022 (Ultimate Edition)
- **Scala Version**: 2.13.12
- **SBT Version**: 1.8.3
- **Hadoop Version**: 3.3.6

## Project Overview

### Workflow

1. **Tokenization**: Uses Byte Pair Encoding (BPE) to tokenize the input corpus, generating token shards.
2. **Vector Embedding Learning**: Uses a Word2Vec model to learn vector embeddings for the tokenized shards.
3. **Cosine Similarity Calculation**: Computes cosine similarities between vector embeddings of tokens and classifies them into categories.
4. **Hadoop and AWS EMR Integration**: The pipeline is designed to be executed on a Hadoop cluster, and the project can be scaled using AWS EMR for large-scale tokenization and vector embedding.

## Running the Project

### Test Files

Test files can be found in the directory `src/test`. To run the tests:

```bash
sbt clean compile test
```

## Set Up Hadoop on Your Local Machine

Ensure that Hadoop is properly installed and configured on your local system. Additionally, set up AWS EMR for cloud deployment if necessary.

## Run the Tokenization and Word2Vec Steps

### 1. Prepare Input Data

Place your text data for processing into the input directory. The directory should contain the text files that you want to tokenize and analyze.

### 2. Tokenization Job

The first MapReduce job tokenizes the input data using BPE (Byte Pair Encoding) and stores the tokenized data in the specified output directory.

- **Input:** Directory containing text files for tokenization.
- **Output:** Tokenized data stored in the specified Hadoop directory.

**Command to run the Tokenization Job:**
```bash
hadoop jar <your-jar-file>.jar Main <input-directory> <tokenization-output-directory>
Replace /path/to/input and /path/to/output with the correct paths on your system.
```

Output Structure

	•	Tokenization Output: Tokenized version of the input text files is stored in the specified output directory.
	•	Vector Embeddings Output: Word2Vec embeddings for tokens are generated and stored in a sub-directory vector-embeddings.
	•	Cosine Similarity Output: The cosine similarity between word vectors is computed and categorized.

Configuration

The Main object controls the flow of the MapReduce jobs. Here are the key configurations to note:

	•	inputPath: The directory containing input text files.
	•	tokenizationOutputPath: The directory to store tokenized data.
	•	word2vecOutputPath: The directory to store word vectors and cosine similarity results.

Project Components

Tokenization Job

The first MapReduce job processes the input text to generate token sequences using BPE. This prepares the data for further processing in word embedding generation.

Word2Vec Job

The second MapReduce job reads the tokenized output and uses the Word2Vec algorithm to generate word embeddings. It calculates cosine similarity between word vectors to identify relationships between tokens.

Cosine Similarity Categories

The cosine similarity scores are classified into categories for easier analysis:

	•	Class A: [0-0.25]
	•	Class B: (0.25-0.5]
	•	Class C: (0.5-0.75]
	•	Class D: (0.75-1.0]

These categories help to interpret the semantic relationships between tokens in the text.

AWS EMR Deployment

For large-scale processing, the project can be deployed on AWS EMR by setting up an EMR cluster and configuring the MapReduce jobs to run on the cloud.

Prerequisites

	•	Hadoop: Installed and configured on your local machine.
	•	AWS Account: For setting up AWS EMR.
	•	Scala and SBT: Installed for building and running the project.
	•	Git: To clone and manage the project repository.
	•	IDE: Use IntelliJ or any preferred IDE for coding and development.

Usage

To execute the project, follow these steps:

	1.	Data Preparation: Ensure your input text files are in the proper format and located in the input directory.
	2.	Run Tokenization Job: Execute the first MapReduce job for tokenization.
	3.	Run Word2Vec Job: Execute the second MapReduce job for word vector generation and cosine similarity computation.
	4.	Result Analysis: Examine the generated output files to analyze token embeddings and similarity scores.

Conclusion

This project demonstrates how distributed computing can be used to build and analyze large-scale language models. Using Hadoop’s MapReduce and AWS EMR, tokenization and word embedding generation are done efficiently, allowing processing of large datasets for NLP tasks.

