/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.demo.kafka.kafkaassignment.dto;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class Patient extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 154819021296160229L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Patient\",\"namespace\":\"com.demo.kafka.kafkaassignment.dto\",\"fields\":[{\"name\":\"case_NUMBER\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_FIRST_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_MIDDLE_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_LAST_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_SEX\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_DOB\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_PLANE_TYPE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_PLAN_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mysource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Patient> ENCODER =
      new BinaryMessageEncoder<Patient>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Patient> DECODER =
      new BinaryMessageDecoder<Patient>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Patient> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Patient> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Patient> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Patient>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Patient to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Patient from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Patient instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Patient fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String case_NUMBER;
  private String pat_ID;
  private String pat_FIRST_NAME;
  private String pat_MIDDLE_NAME;
  private String pat_LAST_NAME;
  private String pat_SEX;
  private String pat_DOB;
  private String pat_PLANE_TYPE;
  private String pat_PLAN_NAME;
  private String mysource;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Patient() {}

  /**
   * All-args constructor.
   * @param case_NUMBER The new value for case_NUMBER
   * @param pat_ID The new value for pat_ID
   * @param pat_FIRST_NAME The new value for pat_FIRST_NAME
   * @param pat_MIDDLE_NAME The new value for pat_MIDDLE_NAME
   * @param pat_LAST_NAME The new value for pat_LAST_NAME
   * @param pat_SEX The new value for pat_SEX
   * @param pat_DOB The new value for pat_DOB
   * @param pat_PLANE_TYPE The new value for pat_PLANE_TYPE
   * @param pat_PLAN_NAME The new value for pat_PLAN_NAME
   * @param mysource The new value for mysource
   */
  public Patient(String case_NUMBER, String pat_ID, String pat_FIRST_NAME, String pat_MIDDLE_NAME, String pat_LAST_NAME, String pat_SEX, String pat_DOB, String pat_PLANE_TYPE, String pat_PLAN_NAME, String mysource) {
    this.case_NUMBER = case_NUMBER;
    this.pat_ID = pat_ID;
    this.pat_FIRST_NAME = pat_FIRST_NAME;
    this.pat_MIDDLE_NAME = pat_MIDDLE_NAME;
    this.pat_LAST_NAME = pat_LAST_NAME;
    this.pat_SEX = pat_SEX;
    this.pat_DOB = pat_DOB;
    this.pat_PLANE_TYPE = pat_PLANE_TYPE;
    this.pat_PLAN_NAME = pat_PLAN_NAME;
    this.mysource = mysource;
  }

  public SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return case_NUMBER;
    case 1: return pat_ID;
    case 2: return pat_FIRST_NAME;
    case 3: return pat_MIDDLE_NAME;
    case 4: return pat_LAST_NAME;
    case 5: return pat_SEX;
    case 6: return pat_DOB;
    case 7: return pat_PLANE_TYPE;
    case 8: return pat_PLAN_NAME;
    case 9: return mysource;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: case_NUMBER = value$ != null ? value$.toString() : null; break;
    case 1: pat_ID = value$ != null ? value$.toString() : null; break;
    case 2: pat_FIRST_NAME = value$ != null ? value$.toString() : null; break;
    case 3: pat_MIDDLE_NAME = value$ != null ? value$.toString() : null; break;
    case 4: pat_LAST_NAME = value$ != null ? value$.toString() : null; break;
    case 5: pat_SEX = value$ != null ? value$.toString() : null; break;
    case 6: pat_DOB = value$ != null ? value$.toString() : null; break;
    case 7: pat_PLANE_TYPE = value$ != null ? value$.toString() : null; break;
    case 8: pat_PLAN_NAME = value$ != null ? value$.toString() : null; break;
    case 9: mysource = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'case_NUMBER' field.
   * @return The value of the 'case_NUMBER' field.
   */
  public String getCaseNUMBER() {
    return case_NUMBER;
  }


  /**
   * Sets the value of the 'case_NUMBER' field.
   * @param value the value to set.
   */
  public void setCaseNUMBER(String value) {
    this.case_NUMBER = value;
  }

  /**
   * Gets the value of the 'pat_ID' field.
   * @return The value of the 'pat_ID' field.
   */
  public String getPatID() {
    return pat_ID;
  }


  /**
   * Sets the value of the 'pat_ID' field.
   * @param value the value to set.
   */
  public void setPatID(String value) {
    this.pat_ID = value;
  }

  /**
   * Gets the value of the 'pat_FIRST_NAME' field.
   * @return The value of the 'pat_FIRST_NAME' field.
   */
  public String getPatFIRSTNAME() {
    return pat_FIRST_NAME;
  }


  /**
   * Sets the value of the 'pat_FIRST_NAME' field.
   * @param value the value to set.
   */
  public void setPatFIRSTNAME(String value) {
    this.pat_FIRST_NAME = value;
  }

  /**
   * Gets the value of the 'pat_MIDDLE_NAME' field.
   * @return The value of the 'pat_MIDDLE_NAME' field.
   */
  public String getPatMIDDLENAME() {
    return pat_MIDDLE_NAME;
  }


  /**
   * Sets the value of the 'pat_MIDDLE_NAME' field.
   * @param value the value to set.
   */
  public void setPatMIDDLENAME(String value) {
    this.pat_MIDDLE_NAME = value;
  }

  /**
   * Gets the value of the 'pat_LAST_NAME' field.
   * @return The value of the 'pat_LAST_NAME' field.
   */
  public String getPatLASTNAME() {
    return pat_LAST_NAME;
  }


  /**
   * Sets the value of the 'pat_LAST_NAME' field.
   * @param value the value to set.
   */
  public void setPatLASTNAME(String value) {
    this.pat_LAST_NAME = value;
  }

  /**
   * Gets the value of the 'pat_SEX' field.
   * @return The value of the 'pat_SEX' field.
   */
  public String getPatSEX() {
    return pat_SEX;
  }


  /**
   * Sets the value of the 'pat_SEX' field.
   * @param value the value to set.
   */
  public void setPatSEX(String value) {
    this.pat_SEX = value;
  }

  /**
   * Gets the value of the 'pat_DOB' field.
   * @return The value of the 'pat_DOB' field.
   */
  public String getPatDOB() {
    return pat_DOB;
  }


  /**
   * Sets the value of the 'pat_DOB' field.
   * @param value the value to set.
   */
  public void setPatDOB(String value) {
    this.pat_DOB = value;
  }

  /**
   * Gets the value of the 'pat_PLANE_TYPE' field.
   * @return The value of the 'pat_PLANE_TYPE' field.
   */
  public String getPatPLANETYPE() {
    return pat_PLANE_TYPE;
  }


  /**
   * Sets the value of the 'pat_PLANE_TYPE' field.
   * @param value the value to set.
   */
  public void setPatPLANETYPE(String value) {
    this.pat_PLANE_TYPE = value;
  }

  /**
   * Gets the value of the 'pat_PLAN_NAME' field.
   * @return The value of the 'pat_PLAN_NAME' field.
   */
  public String getPatPLANNAME() {
    return pat_PLAN_NAME;
  }


  /**
   * Sets the value of the 'pat_PLAN_NAME' field.
   * @param value the value to set.
   */
  public void setPatPLANNAME(String value) {
    this.pat_PLAN_NAME = value;
  }

  /**
   * Gets the value of the 'mysource' field.
   * @return The value of the 'mysource' field.
   */
  public String getMysource() {
    return mysource;
  }


  /**
   * Sets the value of the 'mysource' field.
   * @param value the value to set.
   */
  public void setMysource(String value) {
    this.mysource = value;
  }

  /**
   * Creates a new Patient RecordBuilder.
   * @return A new Patient RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new Patient RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Patient RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new Patient RecordBuilder by copying an existing Patient instance.
   * @param other The existing instance to copy.
   * @return A new Patient RecordBuilder
   */
  public static Builder newBuilder(Patient other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for Patient instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Patient>
    implements org.apache.avro.data.RecordBuilder<Patient> {

    private String case_NUMBER;
    private String pat_ID;
    private String pat_FIRST_NAME;
    private String pat_MIDDLE_NAME;
    private String pat_LAST_NAME;
    private String pat_SEX;
    private String pat_DOB;
    private String pat_PLANE_TYPE;
    private String pat_PLAN_NAME;
    private String mysource;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.case_NUMBER)) {
        this.case_NUMBER = data().deepCopy(fields()[0].schema(), other.case_NUMBER);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.pat_ID)) {
        this.pat_ID = data().deepCopy(fields()[1].schema(), other.pat_ID);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.pat_FIRST_NAME)) {
        this.pat_FIRST_NAME = data().deepCopy(fields()[2].schema(), other.pat_FIRST_NAME);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.pat_MIDDLE_NAME)) {
        this.pat_MIDDLE_NAME = data().deepCopy(fields()[3].schema(), other.pat_MIDDLE_NAME);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.pat_LAST_NAME)) {
        this.pat_LAST_NAME = data().deepCopy(fields()[4].schema(), other.pat_LAST_NAME);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.pat_SEX)) {
        this.pat_SEX = data().deepCopy(fields()[5].schema(), other.pat_SEX);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.pat_DOB)) {
        this.pat_DOB = data().deepCopy(fields()[6].schema(), other.pat_DOB);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.pat_PLANE_TYPE)) {
        this.pat_PLANE_TYPE = data().deepCopy(fields()[7].schema(), other.pat_PLANE_TYPE);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.pat_PLAN_NAME)) {
        this.pat_PLAN_NAME = data().deepCopy(fields()[8].schema(), other.pat_PLAN_NAME);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
      if (isValidValue(fields()[9], other.mysource)) {
        this.mysource = data().deepCopy(fields()[9].schema(), other.mysource);
        fieldSetFlags()[9] = other.fieldSetFlags()[9];
      }
    }

    /**
     * Creates a Builder by copying an existing Patient instance
     * @param other The existing instance to copy.
     */
    private Builder(Patient other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.case_NUMBER)) {
        this.case_NUMBER = data().deepCopy(fields()[0].schema(), other.case_NUMBER);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.pat_ID)) {
        this.pat_ID = data().deepCopy(fields()[1].schema(), other.pat_ID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.pat_FIRST_NAME)) {
        this.pat_FIRST_NAME = data().deepCopy(fields()[2].schema(), other.pat_FIRST_NAME);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.pat_MIDDLE_NAME)) {
        this.pat_MIDDLE_NAME = data().deepCopy(fields()[3].schema(), other.pat_MIDDLE_NAME);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.pat_LAST_NAME)) {
        this.pat_LAST_NAME = data().deepCopy(fields()[4].schema(), other.pat_LAST_NAME);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.pat_SEX)) {
        this.pat_SEX = data().deepCopy(fields()[5].schema(), other.pat_SEX);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.pat_DOB)) {
        this.pat_DOB = data().deepCopy(fields()[6].schema(), other.pat_DOB);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.pat_PLANE_TYPE)) {
        this.pat_PLANE_TYPE = data().deepCopy(fields()[7].schema(), other.pat_PLANE_TYPE);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.pat_PLAN_NAME)) {
        this.pat_PLAN_NAME = data().deepCopy(fields()[8].schema(), other.pat_PLAN_NAME);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.mysource)) {
        this.mysource = data().deepCopy(fields()[9].schema(), other.mysource);
        fieldSetFlags()[9] = true;
      }
    }

    /**
      * Gets the value of the 'case_NUMBER' field.
      * @return The value.
      */
    public String getCaseNUMBER() {
      return case_NUMBER;
    }


    /**
      * Sets the value of the 'case_NUMBER' field.
      * @param value The value of 'case_NUMBER'.
      * @return This builder.
      */
    public Builder setCaseNUMBER(String value) {
      validate(fields()[0], value);
      this.case_NUMBER = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'case_NUMBER' field has been set.
      * @return True if the 'case_NUMBER' field has been set, false otherwise.
      */
    public boolean hasCaseNUMBER() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'case_NUMBER' field.
      * @return This builder.
      */
    public Builder clearCaseNUMBER() {
      case_NUMBER = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_ID' field.
      * @return The value.
      */
    public String getPatID() {
      return pat_ID;
    }


    /**
      * Sets the value of the 'pat_ID' field.
      * @param value The value of 'pat_ID'.
      * @return This builder.
      */
    public Builder setPatID(String value) {
      validate(fields()[1], value);
      this.pat_ID = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_ID' field has been set.
      * @return True if the 'pat_ID' field has been set, false otherwise.
      */
    public boolean hasPatID() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'pat_ID' field.
      * @return This builder.
      */
    public Builder clearPatID() {
      pat_ID = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_FIRST_NAME' field.
      * @return The value.
      */
    public String getPatFIRSTNAME() {
      return pat_FIRST_NAME;
    }


    /**
      * Sets the value of the 'pat_FIRST_NAME' field.
      * @param value The value of 'pat_FIRST_NAME'.
      * @return This builder.
      */
    public Builder setPatFIRSTNAME(String value) {
      validate(fields()[2], value);
      this.pat_FIRST_NAME = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_FIRST_NAME' field has been set.
      * @return True if the 'pat_FIRST_NAME' field has been set, false otherwise.
      */
    public boolean hasPatFIRSTNAME() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'pat_FIRST_NAME' field.
      * @return This builder.
      */
    public Builder clearPatFIRSTNAME() {
      pat_FIRST_NAME = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_MIDDLE_NAME' field.
      * @return The value.
      */
    public String getPatMIDDLENAME() {
      return pat_MIDDLE_NAME;
    }


    /**
      * Sets the value of the 'pat_MIDDLE_NAME' field.
      * @param value The value of 'pat_MIDDLE_NAME'.
      * @return This builder.
      */
    public Builder setPatMIDDLENAME(String value) {
      validate(fields()[3], value);
      this.pat_MIDDLE_NAME = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_MIDDLE_NAME' field has been set.
      * @return True if the 'pat_MIDDLE_NAME' field has been set, false otherwise.
      */
    public boolean hasPatMIDDLENAME() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'pat_MIDDLE_NAME' field.
      * @return This builder.
      */
    public Builder clearPatMIDDLENAME() {
      pat_MIDDLE_NAME = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_LAST_NAME' field.
      * @return The value.
      */
    public String getPatLASTNAME() {
      return pat_LAST_NAME;
    }


    /**
      * Sets the value of the 'pat_LAST_NAME' field.
      * @param value The value of 'pat_LAST_NAME'.
      * @return This builder.
      */
    public Builder setPatLASTNAME(String value) {
      validate(fields()[4], value);
      this.pat_LAST_NAME = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_LAST_NAME' field has been set.
      * @return True if the 'pat_LAST_NAME' field has been set, false otherwise.
      */
    public boolean hasPatLASTNAME() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'pat_LAST_NAME' field.
      * @return This builder.
      */
    public Builder clearPatLASTNAME() {
      pat_LAST_NAME = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_SEX' field.
      * @return The value.
      */
    public String getPatSEX() {
      return pat_SEX;
    }


    /**
      * Sets the value of the 'pat_SEX' field.
      * @param value The value of 'pat_SEX'.
      * @return This builder.
      */
    public Builder setPatSEX(String value) {
      validate(fields()[5], value);
      this.pat_SEX = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_SEX' field has been set.
      * @return True if the 'pat_SEX' field has been set, false otherwise.
      */
    public boolean hasPatSEX() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'pat_SEX' field.
      * @return This builder.
      */
    public Builder clearPatSEX() {
      pat_SEX = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_DOB' field.
      * @return The value.
      */
    public String getPatDOB() {
      return pat_DOB;
    }


    /**
      * Sets the value of the 'pat_DOB' field.
      * @param value The value of 'pat_DOB'.
      * @return This builder.
      */
    public Builder setPatDOB(String value) {
      validate(fields()[6], value);
      this.pat_DOB = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_DOB' field has been set.
      * @return True if the 'pat_DOB' field has been set, false otherwise.
      */
    public boolean hasPatDOB() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'pat_DOB' field.
      * @return This builder.
      */
    public Builder clearPatDOB() {
      pat_DOB = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_PLANE_TYPE' field.
      * @return The value.
      */
    public String getPatPLANETYPE() {
      return pat_PLANE_TYPE;
    }


    /**
      * Sets the value of the 'pat_PLANE_TYPE' field.
      * @param value The value of 'pat_PLANE_TYPE'.
      * @return This builder.
      */
    public Builder setPatPLANETYPE(String value) {
      validate(fields()[7], value);
      this.pat_PLANE_TYPE = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_PLANE_TYPE' field has been set.
      * @return True if the 'pat_PLANE_TYPE' field has been set, false otherwise.
      */
    public boolean hasPatPLANETYPE() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'pat_PLANE_TYPE' field.
      * @return This builder.
      */
    public Builder clearPatPLANETYPE() {
      pat_PLANE_TYPE = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'pat_PLAN_NAME' field.
      * @return The value.
      */
    public String getPatPLANNAME() {
      return pat_PLAN_NAME;
    }


    /**
      * Sets the value of the 'pat_PLAN_NAME' field.
      * @param value The value of 'pat_PLAN_NAME'.
      * @return This builder.
      */
    public Builder setPatPLANNAME(String value) {
      validate(fields()[8], value);
      this.pat_PLAN_NAME = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'pat_PLAN_NAME' field has been set.
      * @return True if the 'pat_PLAN_NAME' field has been set, false otherwise.
      */
    public boolean hasPatPLANNAME() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'pat_PLAN_NAME' field.
      * @return This builder.
      */
    public Builder clearPatPLANNAME() {
      pat_PLAN_NAME = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'mysource' field.
      * @return The value.
      */
    public String getMysource() {
      return mysource;
    }


    /**
      * Sets the value of the 'mysource' field.
      * @param value The value of 'mysource'.
      * @return This builder.
      */
    public Builder setMysource(String value) {
      validate(fields()[9], value);
      this.mysource = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'mysource' field has been set.
      * @return True if the 'mysource' field has been set, false otherwise.
      */
    public boolean hasMysource() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'mysource' field.
      * @return This builder.
      */
    public Builder clearMysource() {
      mysource = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Patient build() {
      try {
        Patient record = new Patient();
        record.case_NUMBER = fieldSetFlags()[0] ? this.case_NUMBER : (String) defaultValue(fields()[0]);
        record.pat_ID = fieldSetFlags()[1] ? this.pat_ID : (String) defaultValue(fields()[1]);
        record.pat_FIRST_NAME = fieldSetFlags()[2] ? this.pat_FIRST_NAME : (String) defaultValue(fields()[2]);
        record.pat_MIDDLE_NAME = fieldSetFlags()[3] ? this.pat_MIDDLE_NAME : (String) defaultValue(fields()[3]);
        record.pat_LAST_NAME = fieldSetFlags()[4] ? this.pat_LAST_NAME : (String) defaultValue(fields()[4]);
        record.pat_SEX = fieldSetFlags()[5] ? this.pat_SEX : (String) defaultValue(fields()[5]);
        record.pat_DOB = fieldSetFlags()[6] ? this.pat_DOB : (String) defaultValue(fields()[6]);
        record.pat_PLANE_TYPE = fieldSetFlags()[7] ? this.pat_PLANE_TYPE : (String) defaultValue(fields()[7]);
        record.pat_PLAN_NAME = fieldSetFlags()[8] ? this.pat_PLAN_NAME : (String) defaultValue(fields()[8]);
        record.mysource = fieldSetFlags()[9] ? this.mysource : (String) defaultValue(fields()[9]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Patient>
    WRITER$ = (org.apache.avro.io.DatumWriter<Patient>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Patient>
    READER$ = (org.apache.avro.io.DatumReader<Patient>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.case_NUMBER);

    out.writeString(this.pat_ID);

    out.writeString(this.pat_FIRST_NAME);

    out.writeString(this.pat_MIDDLE_NAME);

    out.writeString(this.pat_LAST_NAME);

    out.writeString(this.pat_SEX);

    out.writeString(this.pat_DOB);

    out.writeString(this.pat_PLANE_TYPE);

    out.writeString(this.pat_PLAN_NAME);

    out.writeString(this.mysource);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.case_NUMBER = in.readString();

      this.pat_ID = in.readString();

      this.pat_FIRST_NAME = in.readString();

      this.pat_MIDDLE_NAME = in.readString();

      this.pat_LAST_NAME = in.readString();

      this.pat_SEX = in.readString();

      this.pat_DOB = in.readString();

      this.pat_PLANE_TYPE = in.readString();

      this.pat_PLAN_NAME = in.readString();

      this.mysource = in.readString();

    } else {
      for (int i = 0; i < 10; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.case_NUMBER = in.readString();
          break;

        case 1:
          this.pat_ID = in.readString();
          break;

        case 2:
          this.pat_FIRST_NAME = in.readString();
          break;

        case 3:
          this.pat_MIDDLE_NAME = in.readString();
          break;

        case 4:
          this.pat_LAST_NAME = in.readString();
          break;

        case 5:
          this.pat_SEX = in.readString();
          break;

        case 6:
          this.pat_DOB = in.readString();
          break;

        case 7:
          this.pat_PLANE_TYPE = in.readString();
          break;

        case 8:
          this.pat_PLAN_NAME = in.readString();
          break;

        case 9:
          this.mysource = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










