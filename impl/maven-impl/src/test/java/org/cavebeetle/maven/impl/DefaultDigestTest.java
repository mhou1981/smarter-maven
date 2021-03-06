package org.cavebeetle.maven.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * The unit tests for {@code DefaultDigest}.
 */
public final class DefaultDigestTest
{
    private byte[] bytes;
    private DefaultDigest digest;
    private DefaultDigest digestCopy;
    private byte[] otherBytes;
    private DefaultDigest otherDigest;

    /**
     * Sets up each unit test.
     */
    @Before
    public void setUp()
    {
        bytes = new byte[256];
        for (int i = 0; i < 256; i++)
        {
            bytes[i] = (byte) i;
        }
        digest = new DefaultDigest(bytes);
        digestCopy = new DefaultDigest(bytes);
        otherBytes = new byte[] { 0x0, 0x2, 0x4, 0x6, 0x8, 0xA, 0xC, 0xE };
        otherDigest = new DefaultDigest(otherBytes);
    }

    /**
     * Tests that a digest is created correctly.
     */
    @Test
    public final void a_digest_is_created_correctly()
    {
        assertEquals(
                "000102030405060708090A0B0C0D0E0F" +
                        "101112131415161718191A1B1C1D1E1F" +
                        "202122232425262728292A2B2C2D2E2F" +
                        "303132333435363738393A3B3C3D3E3F" +
                        "404142434445464748494A4B4C4D4E4F" +
                        "505152535455565758595A5B5C5D5E5F" +
                        "606162636465666768696A6B6C6D6E6F" +
                        "707172737475767778797A7B7C7D7E7F" +
                        "808182838485868788898A8B8C8D8E8F" +
                        "909192939495969798999A9B9C9D9E9F" +
                        "A0A1A2A3A4A5A6A7A8A9AAABACADAEAF" +
                        "B0B1B2B3B4B5B6B7B8B9BABBBCBDBEBF" +
                        "C0C1C2C3C4C5C6C7C8C9CACBCCCDCECF" +
                        "D0D1D2D3D4D5D6D7D8D9DADBDCDDDEDF" +
                        "E0E1E2E3E4E5E6E7E8E9EAEBECEDEEEF" +
                        "F0F1F2F3F4F5F6F7F8F9FAFBFCFDFEFF",
                digest.toString());
    }

    /**
     * Tests that a {@code Digest} has a valid {@code Object#hashCode()} implementation.
     */
    @Test
    public final void a_digest_has_a_valid_hashCode_implementation()
    {
        assertEquals(digest.hashCode(), digest.hashCode());
        assertEquals(digest.hashCode(), digestCopy.hashCode());
        assertNotEquals(digest.hashCode(), otherDigest.hashCode());
        assertNotEquals(digestCopy.hashCode(), otherDigest.hashCode());
    }

    /**
     * Tests that a {@code Digest} has a valid {@code Object#equals} implementation.
     */
    @Test
    public final void a_Digest_has_a_valid_Object_equals_implementation()
    {
        assertTrue(digest.equals(digest));
        assertFalse(digest.equals(null));
        assertFalse(digest.equals(new Object()));
        assertTrue(digest.equals(digestCopy));
        assertTrue(digestCopy.equals(digest));
        assertFalse(digest.equals(otherDigest));
        assertFalse(otherDigest.equals(digest));
    }
}
