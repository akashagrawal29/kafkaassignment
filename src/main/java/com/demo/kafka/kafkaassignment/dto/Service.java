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
public class Service extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 534779307615204417L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Service\",\"namespace\":\"com.demo.kafka.kafkaassignment.dto\",\"fields\":[{\"name\":\"case_NUMBER\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_TYPE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_CODE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_FAC_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_FAC_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_PHY_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_PHY_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mysource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Service> ENCODER =
      new BinaryMessageEncoder<Service>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Service> DECODER =
      new BinaryMessageDecoder<Service>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Service> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Service> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Service> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Service>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Service to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Service from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Service instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Service fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private String case_NUMBER;
  private String svc_ID;
  private String svc_TYPE;
  private String svc_CODE;
  private String svc_FAC_ID;
  private String svc_FAC_NAME;
  private String svc_PHY_ID;
  private String svc_PHY_NAME;
  private String mysource;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Service() {}

  /**
   * All-args constructor.
   * @param case_NUMBER The new value for case_NUMBER
   * @param svc_ID The new value for svc_ID
   * @param svc_TYPE The new value for svc_TYPE
   * @param svc_CODE The new value for svc_CODE
   * @param svc_FAC_ID The new value for svc_FAC_ID
   * @param svc_FAC_NAME The new value for svc_FAC_NAME
   * @param svc_PHY_ID The new value for svc_PHY_ID
   * @param svc_PHY_NAME The new value for svc_PHY_NAME
   * @param mysource The new value for mysource
   */
  public Service(String case_NUMBER, String svc_ID, String svc_TYPE, String svc_CODE, String svc_FAC_ID, String svc_FAC_NAME, String svc_PHY_ID, String svc_PHY_NAME, String mysource) {
    this.case_NUMBER = case_NUMBER;
    this.svc_ID = svc_ID;
    this.svc_TYPE = svc_TYPE;
    this.svc_CODE = svc_CODE;
    this.svc_FAC_ID = svc_FAC_ID;
    this.svc_FAC_NAME = svc_FAC_NAME;
    this.svc_PHY_ID = svc_PHY_ID;
    this.svc_PHY_NAME = svc_PHY_NAME;
    this.mysource = mysource;
  }

  public SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return case_NUMBER;
    case 1: return svc_ID;
    case 2: return svc_TYPE;
    case 3: return svc_CODE;
    case 4: return svc_FAC_ID;
    case 5: return svc_FAC_NAME;
    case 6: return svc_PHY_ID;
    case 7: return svc_PHY_NAME;
    case 8: return mysource;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: case_NUMBER = value$ != null ? value$.toString() : null; break;
    case 1: svc_ID = value$ != null ? value$.toString() : null; break;
    case 2: svc_TYPE = value$ != null ? value$.toString() : null; break;
    case 3: svc_CODE = value$ != null ? value$.toString() : null; break;
    case 4: svc_FAC_ID = value$ != null ? value$.toString() : null; break;
    case 5: svc_FAC_NAME = value$ != null ? value$.toString() : null; break;
    case 6: svc_PHY_ID = value$ != null ? value$.toString() : null; break;
    case 7: svc_PHY_NAME = value$ != null ? value$.toString() : null; break;
    case 8: mysource = value$ != null ? value$.toString() : null; break;
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
   * Gets the value of the 'svc_ID' field.
   * @return The value of the 'svc_ID' field.
   */
  public String getSvcID() {
    return svc_ID;
  }


  /**
   * Sets the value of the 'svc_ID' field.
   * @param value the value to set.
   */
  public void setSvcID(String value) {
    this.svc_ID = value;
  }

  /**
   * Gets the value of the 'svc_TYPE' field.
   * @return The value of the 'svc_TYPE' field.
   */
  public String getSvcTYPE() {
    return svc_TYPE;
  }


  /**
   * Sets the value of the 'svc_TYPE' field.
   * @param value the value to set.
   */
  public void setSvcTYPE(String value) {
    this.svc_TYPE = value;
  }

  /**
   * Gets the value of the 'svc_CODE' field.
   * @return The value of the 'svc_CODE' field.
   */
  public String getSvcCODE() {
    return svc_CODE;
  }


  /**
   * Sets the value of the 'svc_CODE' field.
   * @param value the value to set.
   */
  public void setSvcCODE(String value) {
    this.svc_CODE = value;
  }

  /**
   * Gets the value of the 'svc_FAC_ID' field.
   * @return The value of the 'svc_FAC_ID' field.
   */
  public String getSvcFACID() {
    return svc_FAC_ID;
  }


  /**
   * Sets the value of the 'svc_FAC_ID' field.
   * @param value the value to set.
   */
  public void setSvcFACID(String value) {
    this.svc_FAC_ID = value;
  }

  /**
   * Gets the value of the 'svc_FAC_NAME' field.
   * @return The value of the 'svc_FAC_NAME' field.
   */
  public String getSvcFACNAME() {
    return svc_FAC_NAME;
  }


  /**
   * Sets the value of the 'svc_FAC_NAME' field.
   * @param value the value to set.
   */
  public void setSvcFACNAME(String value) {
    this.svc_FAC_NAME = value;
  }

  /**
   * Gets the value of the 'svc_PHY_ID' field.
   * @return The value of the 'svc_PHY_ID' field.
   */
  public String getSvcPHYID() {
    return svc_PHY_ID;
  }


  /**
   * Sets the value of the 'svc_PHY_ID' field.
   * @param value the value to set.
   */
  public void setSvcPHYID(String value) {
    this.svc_PHY_ID = value;
  }

  /**
   * Gets the value of the 'svc_PHY_NAME' field.
   * @return The value of the 'svc_PHY_NAME' field.
   */
  public String getSvcPHYNAME() {
    return svc_PHY_NAME;
  }


  /**
   * Sets the value of the 'svc_PHY_NAME' field.
   * @param value the value to set.
   */
  public void setSvcPHYNAME(String value) {
    this.svc_PHY_NAME = value;
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
   * Creates a new Service RecordBuilder.
   * @return A new Service RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new Service RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Service RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new Service RecordBuilder by copying an existing Service instance.
   * @param other The existing instance to copy.
   * @return A new Service RecordBuilder
   */
  public static Builder newBuilder(Service other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for Service instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Service>
    implements org.apache.avro.data.RecordBuilder<Service> {

    private String case_NUMBER;
    private String svc_ID;
    private String svc_TYPE;
    private String svc_CODE;
    private String svc_FAC_ID;
    private String svc_FAC_NAME;
    private String svc_PHY_ID;
    private String svc_PHY_NAME;
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
      if (isValidValue(fields()[1], other.svc_ID)) {
        this.svc_ID = data().deepCopy(fields()[1].schema(), other.svc_ID);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.svc_TYPE)) {
        this.svc_TYPE = data().deepCopy(fields()[2].schema(), other.svc_TYPE);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.svc_CODE)) {
        this.svc_CODE = data().deepCopy(fields()[3].schema(), other.svc_CODE);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.svc_FAC_ID)) {
        this.svc_FAC_ID = data().deepCopy(fields()[4].schema(), other.svc_FAC_ID);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.svc_FAC_NAME)) {
        this.svc_FAC_NAME = data().deepCopy(fields()[5].schema(), other.svc_FAC_NAME);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.svc_PHY_ID)) {
        this.svc_PHY_ID = data().deepCopy(fields()[6].schema(), other.svc_PHY_ID);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.svc_PHY_NAME)) {
        this.svc_PHY_NAME = data().deepCopy(fields()[7].schema(), other.svc_PHY_NAME);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.mysource)) {
        this.mysource = data().deepCopy(fields()[8].schema(), other.mysource);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing Service instance
     * @param other The existing instance to copy.
     */
    private Builder(Service other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.case_NUMBER)) {
        this.case_NUMBER = data().deepCopy(fields()[0].schema(), other.case_NUMBER);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.svc_ID)) {
        this.svc_ID = data().deepCopy(fields()[1].schema(), other.svc_ID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.svc_TYPE)) {
        this.svc_TYPE = data().deepCopy(fields()[2].schema(), other.svc_TYPE);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.svc_CODE)) {
        this.svc_CODE = data().deepCopy(fields()[3].schema(), other.svc_CODE);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.svc_FAC_ID)) {
        this.svc_FAC_ID = data().deepCopy(fields()[4].schema(), other.svc_FAC_ID);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.svc_FAC_NAME)) {
        this.svc_FAC_NAME = data().deepCopy(fields()[5].schema(), other.svc_FAC_NAME);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.svc_PHY_ID)) {
        this.svc_PHY_ID = data().deepCopy(fields()[6].schema(), other.svc_PHY_ID);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.svc_PHY_NAME)) {
        this.svc_PHY_NAME = data().deepCopy(fields()[7].schema(), other.svc_PHY_NAME);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.mysource)) {
        this.mysource = data().deepCopy(fields()[8].schema(), other.mysource);
        fieldSetFlags()[8] = true;
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
      * Gets the value of the 'svc_ID' field.
      * @return The value.
      */
    public String getSvcID() {
      return svc_ID;
    }


    /**
      * Sets the value of the 'svc_ID' field.
      * @param value The value of 'svc_ID'.
      * @return This builder.
      */
    public Builder setSvcID(String value) {
      validate(fields()[1], value);
      this.svc_ID = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_ID' field has been set.
      * @return True if the 'svc_ID' field has been set, false otherwise.
      */
    public boolean hasSvcID() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'svc_ID' field.
      * @return This builder.
      */
    public Builder clearSvcID() {
      svc_ID = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'svc_TYPE' field.
      * @return The value.
      */
    public String getSvcTYPE() {
      return svc_TYPE;
    }


    /**
      * Sets the value of the 'svc_TYPE' field.
      * @param value The value of 'svc_TYPE'.
      * @return This builder.
      */
    public Builder setSvcTYPE(String value) {
      validate(fields()[2], value);
      this.svc_TYPE = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_TYPE' field has been set.
      * @return True if the 'svc_TYPE' field has been set, false otherwise.
      */
    public boolean hasSvcTYPE() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'svc_TYPE' field.
      * @return This builder.
      */
    public Builder clearSvcTYPE() {
      svc_TYPE = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'svc_CODE' field.
      * @return The value.
      */
    public String getSvcCODE() {
      return svc_CODE;
    }


    /**
      * Sets the value of the 'svc_CODE' field.
      * @param value The value of 'svc_CODE'.
      * @return This builder.
      */
    public Builder setSvcCODE(String value) {
      validate(fields()[3], value);
      this.svc_CODE = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_CODE' field has been set.
      * @return True if the 'svc_CODE' field has been set, false otherwise.
      */
    public boolean hasSvcCODE() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'svc_CODE' field.
      * @return This builder.
      */
    public Builder clearSvcCODE() {
      svc_CODE = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'svc_FAC_ID' field.
      * @return The value.
      */
    public String getSvcFACID() {
      return svc_FAC_ID;
    }


    /**
      * Sets the value of the 'svc_FAC_ID' field.
      * @param value The value of 'svc_FAC_ID'.
      * @return This builder.
      */
    public Builder setSvcFACID(String value) {
      validate(fields()[4], value);
      this.svc_FAC_ID = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_FAC_ID' field has been set.
      * @return True if the 'svc_FAC_ID' field has been set, false otherwise.
      */
    public boolean hasSvcFACID() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'svc_FAC_ID' field.
      * @return This builder.
      */
    public Builder clearSvcFACID() {
      svc_FAC_ID = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'svc_FAC_NAME' field.
      * @return The value.
      */
    public String getSvcFACNAME() {
      return svc_FAC_NAME;
    }


    /**
      * Sets the value of the 'svc_FAC_NAME' field.
      * @param value The value of 'svc_FAC_NAME'.
      * @return This builder.
      */
    public Builder setSvcFACNAME(String value) {
      validate(fields()[5], value);
      this.svc_FAC_NAME = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_FAC_NAME' field has been set.
      * @return True if the 'svc_FAC_NAME' field has been set, false otherwise.
      */
    public boolean hasSvcFACNAME() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'svc_FAC_NAME' field.
      * @return This builder.
      */
    public Builder clearSvcFACNAME() {
      svc_FAC_NAME = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'svc_PHY_ID' field.
      * @return The value.
      */
    public String getSvcPHYID() {
      return svc_PHY_ID;
    }


    /**
      * Sets the value of the 'svc_PHY_ID' field.
      * @param value The value of 'svc_PHY_ID'.
      * @return This builder.
      */
    public Builder setSvcPHYID(String value) {
      validate(fields()[6], value);
      this.svc_PHY_ID = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_PHY_ID' field has been set.
      * @return True if the 'svc_PHY_ID' field has been set, false otherwise.
      */
    public boolean hasSvcPHYID() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'svc_PHY_ID' field.
      * @return This builder.
      */
    public Builder clearSvcPHYID() {
      svc_PHY_ID = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'svc_PHY_NAME' field.
      * @return The value.
      */
    public String getSvcPHYNAME() {
      return svc_PHY_NAME;
    }


    /**
      * Sets the value of the 'svc_PHY_NAME' field.
      * @param value The value of 'svc_PHY_NAME'.
      * @return This builder.
      */
    public Builder setSvcPHYNAME(String value) {
      validate(fields()[7], value);
      this.svc_PHY_NAME = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'svc_PHY_NAME' field has been set.
      * @return True if the 'svc_PHY_NAME' field has been set, false otherwise.
      */
    public boolean hasSvcPHYNAME() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'svc_PHY_NAME' field.
      * @return This builder.
      */
    public Builder clearSvcPHYNAME() {
      svc_PHY_NAME = null;
      fieldSetFlags()[7] = false;
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
      validate(fields()[8], value);
      this.mysource = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'mysource' field has been set.
      * @return True if the 'mysource' field has been set, false otherwise.
      */
    public boolean hasMysource() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'mysource' field.
      * @return This builder.
      */
    public Builder clearMysource() {
      mysource = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Service build() {
      try {
        Service record = new Service();
        record.case_NUMBER = fieldSetFlags()[0] ? this.case_NUMBER : (String) defaultValue(fields()[0]);
        record.svc_ID = fieldSetFlags()[1] ? this.svc_ID : (String) defaultValue(fields()[1]);
        record.svc_TYPE = fieldSetFlags()[2] ? this.svc_TYPE : (String) defaultValue(fields()[2]);
        record.svc_CODE = fieldSetFlags()[3] ? this.svc_CODE : (String) defaultValue(fields()[3]);
        record.svc_FAC_ID = fieldSetFlags()[4] ? this.svc_FAC_ID : (String) defaultValue(fields()[4]);
        record.svc_FAC_NAME = fieldSetFlags()[5] ? this.svc_FAC_NAME : (String) defaultValue(fields()[5]);
        record.svc_PHY_ID = fieldSetFlags()[6] ? this.svc_PHY_ID : (String) defaultValue(fields()[6]);
        record.svc_PHY_NAME = fieldSetFlags()[7] ? this.svc_PHY_NAME : (String) defaultValue(fields()[7]);
        record.mysource = fieldSetFlags()[8] ? this.mysource : (String) defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Service>
    WRITER$ = (org.apache.avro.io.DatumWriter<Service>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Service>
    READER$ = (org.apache.avro.io.DatumReader<Service>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.case_NUMBER);

    out.writeString(this.svc_ID);

    out.writeString(this.svc_TYPE);

    out.writeString(this.svc_CODE);

    out.writeString(this.svc_FAC_ID);

    out.writeString(this.svc_FAC_NAME);

    out.writeString(this.svc_PHY_ID);

    out.writeString(this.svc_PHY_NAME);

    out.writeString(this.mysource);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.case_NUMBER = in.readString();

      this.svc_ID = in.readString();

      this.svc_TYPE = in.readString();

      this.svc_CODE = in.readString();

      this.svc_FAC_ID = in.readString();

      this.svc_FAC_NAME = in.readString();

      this.svc_PHY_ID = in.readString();

      this.svc_PHY_NAME = in.readString();

      this.mysource = in.readString();

    } else {
      for (int i = 0; i < 9; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.case_NUMBER = in.readString();
          break;

        case 1:
          this.svc_ID = in.readString();
          break;

        case 2:
          this.svc_TYPE = in.readString();
          break;

        case 3:
          this.svc_CODE = in.readString();
          break;

        case 4:
          this.svc_FAC_ID = in.readString();
          break;

        case 5:
          this.svc_FAC_NAME = in.readString();
          break;

        case 6:
          this.svc_PHY_ID = in.readString();
          break;

        case 7:
          this.svc_PHY_NAME = in.readString();
          break;

        case 8:
          this.mysource = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










