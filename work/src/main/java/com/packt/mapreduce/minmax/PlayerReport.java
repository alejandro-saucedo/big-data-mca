package com.packt.mapreduce.minmax;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PlayerReport implements Writable {
    private Text playerName;
    private IntWritable maxScore;
    private IntWritable maxScoreOpposition;
    private IntWritable minScore;
    private IntWritable minScoreOpposition;

    public void write(DataOutput dataOutput) throws IOException {
        playerName.write(dataOutput);
        maxScore.write(dataOutput);
        maxScoreOpposition.write(dataOutput);
        minScore.write(dataOutput);
        minScoreOpposition.write(dataOutput);
    }

    public void readFields(DataInput dataInput) throws IOException {
        playerName.readFields(dataInput);
        maxScore.readFields(dataInput);
        maxScoreOpposition.readFields(dataInput);
        minScore.readFields(dataInput);
        minScoreOpposition.readFields(dataInput);
    }

    public Text getPlayerName() {
        return playerName;
    }

    public void setPlayerName(Text playerName) {
        this.playerName = playerName;
    }

    public IntWritable getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(IntWritable maxScore) {
        this.maxScore = maxScore;
    }

    public IntWritable getMaxScoreOpposition() {
        return maxScoreOpposition;
    }

    public void setMaxScoreOpposition(IntWritable maxScoreOpposition) {
        this.maxScoreOpposition = maxScoreOpposition;
    }

    public IntWritable getMinScore() {
        return minScore;
    }

    public void setMinScore(IntWritable minScore) {
        this.minScore = minScore;
    }

    public IntWritable getMinScoreOpposition() {
        return minScoreOpposition;
    }

    public void setMinScoreOpposition(IntWritable minScoreOpposition) {
        this.minScoreOpposition = minScoreOpposition;
    }

    @Override
    public String toString() {
        return playerName +
                "\t" + maxScore +
                "\t" + maxScoreOpposition +
                "\t" + minScore +
                "\t" + minScoreOpposition;
    }
}
